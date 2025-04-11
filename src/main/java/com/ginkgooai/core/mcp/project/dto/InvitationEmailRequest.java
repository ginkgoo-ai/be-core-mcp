package com.ginkgooai.core.mcp.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class InvitationEmailRequest {

    @Schema(description = "email template enum type, enum values [INVITATION, INVITE_UPLOAD]")
    private String emailTemplateType;

    @Schema(description = "application ids")
    private List<String> applicationIds;

}
