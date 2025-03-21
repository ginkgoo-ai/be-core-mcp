package com.ginkgooai.core.mcp.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Response object containing submission comment details")
public class SubmissionCommentResponse {
    
    @Schema(description = "Unique identifier of the comment",
            example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Content of the comment",
            example = "Great performance in this submission!")
    private String content;

    @Schema(description = "User ID of the comment creator",
            example = "user-123")
    private String createdBy;

    @Schema(description = "Timestamp when the comment was created",
            example = "2025-03-03T02:09:57.713Z")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the comment was last updated",
            example = "2025-03-03T02:09:57.713Z")
    private LocalDateTime updatedAt;

}