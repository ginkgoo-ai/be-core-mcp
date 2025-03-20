package com.ginkgooai.core.mcp.project.dto;


import com.ginkgooai.core.mcp.project.dto.enums.ApplicationStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Schema(description = "Response object containing application details")
public class ApplicationResponse {

    @Schema(description = "Unique identifier of the application", example = "app_12345")
    private String id;

    @Schema(description = "Workspace identifier", example = "ws_12345")
    private String workspaceId;

    @Schema(description = "Project identifier", example = "proj_12345")
    private String projectId;

    @Schema(description = "Role")
    private ProjectRoleResponse role;

    @Schema(description = "Associated talent details")
    private TalentResponse talent;

    @Schema(description = "List of submissions")
    private List<SubmissionResponse> submissions;

    @Schema(description = "Current application status", example = "PENDING")
    private ApplicationStatus status;

    @Schema(description = "List of application notes")
    private List<ApplicationNoteResponse> notes;

    @Schema(description = "List of application comments")
    private List<ApplicationCommentResponse> comments;

    @Schema(description = "User who created the application", example = "user_12345")
    private String createdBy;

    @Schema(description = "Creation timestamp")
    private LocalDateTime createdAt;

    @Schema(description = "Last update timestamp")
    private LocalDateTime updatedAt;

}