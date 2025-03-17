package com.ginkgooai.core.mcp.project.client;

import com.ginkgooai.core.common.config.FeignConfig;
import com.ginkgooai.core.mcp.project.model.ProjectBasicResponse;
import com.ginkgooai.core.mcp.project.model.ProjectResponse;
import com.ginkgooai.core.mcp.project.model.ProjectRoleResponse;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "project-service", url="${core-project-uri}", configuration = FeignConfig.class)
public interface ProjectClient {
    @GetMapping("/projects/basic")
    ResponseEntity<List<ProjectBasicResponse>> getAllProjectsBasicInfo();


    @GetMapping("/projects/{id}")
    ResponseEntity<ProjectResponse> getProjectById(@PathVariable String id);

    @GetMapping("/projects/{projectId}/roles")
    ResponseEntity<Page<ProjectRoleResponse>> getProjectRoles(
            @PathVariable String projectId,
            @Parameter(description = "Page number (zero-based)", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size", example = "10") @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Sort direction (ASC/DESC)", example = "DESC") @RequestParam(defaultValue = "DESC") String sortDirection,
            @Parameter(description = "Sort field (e.g., updatedAt)", example = "updatedAt") @RequestParam(defaultValue = "updatedAt") String sortField);
}

