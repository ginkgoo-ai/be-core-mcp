package com.ginkgooai.core.mcp.project.config;


import com.ginkgooai.core.mcp.project.service.ProjectService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolsConfig {

    @Bean
    public ToolCallbackProvider projectTools(ProjectService projectService) {
        return MethodToolCallbackProvider.builder().toolObjects(projectService).build();
    }
}
