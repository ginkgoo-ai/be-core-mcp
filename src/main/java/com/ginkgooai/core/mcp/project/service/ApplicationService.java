package com.ginkgooai.core.mcp.project.service;


import com.ginkgooai.core.mcp.project.client.ApplicationClient;
import com.ginkgooai.core.mcp.project.dto.ApplicationNoteResponse;
import com.ginkgooai.core.mcp.project.dto.ApplicationResponse;
import com.ginkgooai.core.mcp.project.dto.NoteCreateRequest;
import com.ginkgooai.core.mcp.project.dto.enums.ApplicationStatus;
import com.ginkgooai.core.mcp.tools.McpToolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService implements McpToolsService {

    private final ApplicationClient applicationClient;

    @Tool(description = "Get all applications")
    Page<ApplicationResponse> listApplications(
            String params, String workspaceId,
            @ToolParam(description = "Project id", required = false) String projectId,
            @ToolParam(description = "Role id", required = false) String roleId,
            @ToolParam(description = "Key word (include [talentName, talentEmail, agentName, agentEmail, roleName])", required = false) String keyword,
            @ToolParam(description = "Application status", required = false) ApplicationStatus status,
            @ToolParam(description = "Page number (zero-based)") int page,
            @ToolParam(description = "Page size") int size,
            @ToolParam(description = "Sort direction (ASC/DESC)", required = false) String sortDirection,
            @ToolParam(description = "Sort field (e.g., updatedAt)", required = false) String sortField){
        return applicationClient.listApplications(projectId, roleId, keyword, status, page, size, sortDirection, sortField).getBody();
    }

    @Tool(description = "Get an application by ID")
    ApplicationResponse getApplication(
            String params, String workspaceId,
            @ToolParam(description = "Application ID") String applicationId){
        return applicationClient.getApplication(applicationId).getBody();
    }

    @Tool(description = "Add a note to an application")
    List<ApplicationNoteResponse> addNote(
            String params, String workspaceId,
            @ToolParam(description = "Application ID") String applicationId,
            @ToolParam(description = "Request object for creating a new note") NoteCreateRequest request){
        return applicationClient.addNote(applicationId, request).getBody();
    }
}
