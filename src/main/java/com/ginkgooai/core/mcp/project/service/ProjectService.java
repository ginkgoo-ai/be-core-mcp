package com.ginkgooai.core.mcp.project.service;


import com.ginkgooai.core.mcp.project.client.ProjectClient;
import com.ginkgooai.core.mcp.project.dto.*;
import com.ginkgooai.core.mcp.tools.McpToolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService implements McpToolsService {

    private final ProjectClient projectClient;


    @Tool(description = "Get projects by paginated list ")
    public Page<ProjectResponse> getProjects(
            String params, String workspaceId,
            @ToolParam(description = "Page number (zero-based)") int page,
            @ToolParam(description = "Page size") int size,
            @ToolParam(description = "Sort direction (ASC/DESC)", required = false) String sortDirection,
            @ToolParam(description = "Sort field (e.g., updatedAt)", required = false) String sortField,
            @ToolParam(description = "Filter by project name (fuzzy search)", required = false) String name,
            @ToolParam(description = "Filter by project status (e.g., DRAFTING, ACTIVE, COMPLETED, PENDING_REVIEW)", required = false)  ProjectStatus status){

        return projectClient.getProjects(page, size, sortDirection, sortField, name, status).getBody();
    }

    @Tool(description = "Get project detail by project id")
    public ProjectResponse getProjectById(
            String params,
            String workspaceId,
            @ToolParam(description = "project id") String projectId) {
        return projectClient.getProjectById(projectId).getBody();
    }

    @Tool(description = "Get project roles by project id")
    public Page<ProjectRoleResponse> getProjectRolesByProjectId(
            String params,
            String workspaceId,
            @ToolParam(description = "project id")String projectId,
            @ToolParam(description = "Sort direction (ASC/DESC)", required = false) String sort,
            @ToolParam(description = "Sort field (e.g., updatedAt)", required = false) String sortField) {
        return projectClient.getProjectRoles(projectId, 0, 100, sort, sortField).getBody();
    }

    @Tool(description = "Create project")
    public ProjectResponse createProject(
            String params,
            String workspaceId,
            @ToolParam(description = "create project request body") ProjectCreateRequest projectCreateRequest) {
        return projectClient.createProject(projectCreateRequest).getBody();
    }

    @Tool(description = "Update project role")
    public ProjectRoleResponse updateRole(
            @ToolParam String projectId,
            @ToolParam String roleId,
            @ToolParam ProjectRoleRequest request){
        return projectClient.updateRole(projectId, roleId, request).getBody();
    }
}
