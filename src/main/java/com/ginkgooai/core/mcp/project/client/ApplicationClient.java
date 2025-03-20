package com.ginkgooai.core.mcp.project.client;

import com.ginkgooai.core.common.config.FeignConfig;
import com.ginkgooai.core.mcp.project.dto.ApplicationNoteResponse;
import com.ginkgooai.core.mcp.project.dto.ApplicationResponse;
import com.ginkgooai.core.mcp.project.dto.NoteCreateRequest;
import com.ginkgooai.core.mcp.project.dto.enums.ApplicationStatus;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "project-service-application", url="${core-project-uri}", configuration = FeignConfig.class)
public interface ApplicationClient {

    @GetMapping("/applications")
    ResponseEntity<Page<ApplicationResponse>> listApplications(
            @RequestParam(required = false) String projectId,
            @RequestParam(required = false) String roleId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) ApplicationStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "DESC") String sortDirection,
            @RequestParam(defaultValue = "updatedAt") String sortField);


    @GetMapping("/applications/{id}")
    ResponseEntity<ApplicationResponse> getApplication(@Parameter(description = "Application ID", example = "app_12345")
                                                              @PathVariable String id);

    @PostMapping("/applications/{id}/notes")
    ResponseEntity<List<ApplicationNoteResponse>> addNote(
            @Parameter(description = "Application ID", example = "app_12345")
            @PathVariable String id,
            @RequestBody NoteCreateRequest request);
}

