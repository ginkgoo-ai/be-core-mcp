package com.ginkgooai.core.mcp.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Data
@Builder
@Schema(description = "Response object containing talent information")
public class TalentResponse {
    @Schema(description = "Unique identifier for the talent")
    private String id;

    @Schema(description = "Workspace identifier that the talent belongs to")
    private String workspaceId;

    @Schema(description = "Full name of the talent")
    private String name;

    @Schema(description = "Contact email address")
    private String email;

    @Schema(description = "IMDB profile URL")
    private String imdbProfileUrl;

    @Schema(description = "Spotlight profile URL")
    private String spotlightProfileUrl;

    @Schema(description = "URL of the talent's profile photo")
    private String profilePhotoUrl;

    @Schema(description = "Name of the talent's agency")
    private String agencyName;

    @Schema(description = "Name of the talent's agent")
    private String agentName;

    @Schema(description = "Contact email of the talent's agent")
    private String agentEmail;
  
    @Schema(description = "List of notable works the talent is known for")
    private Set<KnownForItem> knownFor;

    @Schema(description = "Personal details including physical attributes, skills, and other relevant information")
    private Map<String, String> personalDetails;

    @Schema(description = "Current status of the talent (e.g., ACTIVE, INACTIVE)")
    private String status;

    @Schema(description = "Timestamp when the talent record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp of the last update to the talent record")
    private LocalDateTime updatedAt;

    @Schema(description = "Additional dynamic attributes for the talent")
    private Map<String, Object> attributes;

}