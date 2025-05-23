package com.ginkgooai.core.mcp.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(description = "Request payload for creating or updating a project")
public class ProjectUpdateRequest {

    @Schema(description = "Name of the project", example = "Summer Feature 2025")
    @NotEmpty
    private String name;

    @Schema(description = "Description of the project", example = "A summer feature film about...")
    @NotEmpty
    private String description;

    @Schema(description = "Plot line of the project", example = "A young hero embarks on a journey...")
    @NotEmpty
    private String plotLine;

    @Schema(description = "Status of the project", example = "IN_PROGRESS")
    private ProjectStatus status;

    @Schema(description = "Producer of the project", example = "Mark Ronson")
    @NotEmpty
    private String producer;

    @Schema(description = "Project poster Url", example = "www.example.com/poster.jpg")
    @NotEmpty
    private String posterUrl;
}