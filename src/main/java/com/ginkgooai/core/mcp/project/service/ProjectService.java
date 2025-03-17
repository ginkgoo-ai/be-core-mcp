package com.ginkgooai.core.mcp.project.service;


import com.ginkgooai.core.common.utils.ContextUtils;
import com.ginkgooai.core.mcp.project.client.ProjectClient;
import com.ginkgooai.core.mcp.project.model.ProjectBasicResponse;
import com.ginkgooai.core.mcp.project.model.ProjectResponse;
import com.ginkgooai.core.mcp.project.model.ProjectRoleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectClient projectClient;

    private void setAuthorization(String authorization){
        ContextUtils.get().put(HttpHeaders.AUTHORIZATION, authorization);
    }

    @Tool(description = "Get all project basic info")
    public List<String> getAllProjectNames(String params){
        setAuthorization(params);
        return Objects.requireNonNull(projectClient.getAllProjectsBasicInfo().getBody()).stream().map(ProjectBasicResponse::getId).toList();
    }

    @Tool(description = "Get project detail by project id")
    public ProjectResponse getProjectById(String params, String projectId){
        setAuthorization(params);
        return projectClient.getProjectById(projectId).getBody();
    }

    @Tool(description = "Get project roles by project id")
    public Page<ProjectRoleResponse> getProjectRolesByProjectId(String params, String projectId, String sort){
        setAuthorization(params);
        return projectClient.getProjectRoles(projectId, 0, 100, sort, null).getBody();
    }

}
