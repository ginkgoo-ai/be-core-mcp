package com.ginkgooai.core.mcp.project.service;


import com.ginkgooai.core.mcp.project.client.ApplicationClient;
import com.ginkgooai.core.mcp.project.dto.ApplicationNoteResponse;
import com.ginkgooai.core.mcp.project.dto.ApplicationResponse;
import com.ginkgooai.core.mcp.project.dto.NoteCreateRequest;
import com.ginkgooai.core.mcp.project.dto.enums.ApplicationStatus;
import com.ginkgooai.core.mcp.tools.McpToolsService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService implements McpToolsService {

    private final ApplicationClient applicationClient;

    @Tool(description = "Get all applications")
    Page<ApplicationResponse> listApplications(
            @RequestParam(required = false) String projectId,
            @RequestParam(required = false) String roleId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) ApplicationStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "DESC") String sortDirection,
            @RequestParam(defaultValue = "updatedAt") String sortField){
        return applicationClient.listApplications(projectId, roleId, keyword, status, page, size, sortDirection, sortField).getBody();
    }


    @Tool(description = "Get an application by ID")
    ApplicationResponse getApplication(@Parameter(description = "Application ID", example = "app_12345")
                                                       @PathVariable String id){
        return applicationClient.getApplication(id).getBody();
    }

    @Tool(description = "Add a note to an application")
    List<ApplicationNoteResponse> addNote(
            @Parameter(description = "Application ID", example = "app_12345")
            @PathVariable String id,
            @RequestBody NoteCreateRequest request){
        return applicationClient.addNote(id, request).getBody();
    }
}
