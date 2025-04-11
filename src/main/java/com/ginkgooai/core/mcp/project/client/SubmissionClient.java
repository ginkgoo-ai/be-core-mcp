package com.ginkgooai.core.mcp.project.client;

import com.ginkgooai.core.common.config.FeignConfig;
import com.ginkgooai.core.mcp.project.dto.ApplicationNoteResponse;
import com.ginkgooai.core.mcp.project.dto.ApplicationResponse;
import com.ginkgooai.core.mcp.project.dto.InvitationEmailRequest;
import com.ginkgooai.core.mcp.project.dto.NoteCreateRequest;
import com.ginkgooai.core.mcp.project.dto.enums.ApplicationStatus;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "project-service-submission", url="${core-project-uri}", configuration = FeignConfig.class)
public interface SubmissionClient {

    @PostMapping("/submissions/invitation")
    ResponseEntity<?> sendInvitationEmail(
            @Parameter(description = "Invitation email request containing template type and application IDs", required = true)
            @RequestBody InvitationEmailRequest request);
}

