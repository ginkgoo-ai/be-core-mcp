package com.ginkgooai.core.mcp.config;


import com.ginkgooai.core.mcp.project.service.ProjectService;
import com.ginkgooai.core.mcp.tools.McpToolsService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ToolsConfig {

    @Bean
    public ToolCallbackProvider projectTools(List<McpToolsService> mcpToolsServices) {
        return MethodToolCallbackProvider.builder().toolObjects(mcpToolsServices.toArray()).build();
    }
}
