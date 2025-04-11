package com.ginkgooai.core.mcp.project.service;


import com.ginkgooai.core.mcp.project.client.SubmissionClient;
import com.ginkgooai.core.mcp.project.dto.InvitationEmailRequest;
import com.ginkgooai.core.mcp.tools.McpToolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionService implements McpToolsService{

    public final SubmissionClient submissionClient;


    @Tool(description = "Send an invitation email to a talent")
    ResponseEntity<?> sendInvitationEmail(
            String params, String workspaceId,
            @ToolParam(description = "Invitation email request containing template type and application IDs")InvitationEmailRequest request){
        return submissionClient.sendInvitationEmail(request);
    }
}
