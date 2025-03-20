package com.ginkgooai.core.mcp.project.client;

import com.ginkgooai.core.common.config.FeignConfig;
import com.ginkgooai.core.mcp.project.dto.ProjectCreateRequest;
import com.ginkgooai.core.mcp.project.dto.ProjectResponse;
import com.ginkgooai.core.mcp.project.dto.ProjectRoleResponse;
import com.ginkgooai.core.mcp.project.dto.ProjectStatus;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "project-service-project", url="${core-project-uri}", configuration = FeignConfig.class)
public interface ProjectClient {
    @GetMapping("/projects")
    ResponseEntity<Page<ProjectResponse>> getProjects(
            @Parameter(description = "Page number (zero-based)", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size", example = "10") @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Sort direction (ASC/DESC)", example = "DESC") @RequestParam(defaultValue = "DESC") String sortDirection,
            @Parameter(description = "Sort field (e.g., updatedAt)", example = "updatedAt") @RequestParam(defaultValue = "updatedAt") String sortField,
            @Parameter(description = "Filter by project name (fuzzy search)", example = "Enchanted") @RequestParam(required = false) String name,
            @Parameter(description = "Filter by project status (e.g., DRAFTING, ACTIVE, COMPLETED, PENDING_REVIEW)", example = "IN_PROGRESS") @RequestParam(required = false) ProjectStatus status);

    @GetMapping("/projects/{id}")
    ResponseEntity<ProjectResponse> getProjectById(@PathVariable String id);

    @GetMapping("/projects/{projectId}/roles")
    ResponseEntity<Page<ProjectRoleResponse>> getProjectRoles(
            @PathVariable String projectId,
            @Parameter(description = "Page number (zero-based)", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size", example = "10") @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Sort direction (ASC/DESC)", example = "DESC") @RequestParam(defaultValue = "DESC") String sortDirection,
            @Parameter(description = "Sort field (e.g., updatedAt)", example = "updatedAt") @RequestParam(defaultValue = "updatedAt") String sortField);

    @PostMapping("/projects")
    ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectCreateRequest request);
}

