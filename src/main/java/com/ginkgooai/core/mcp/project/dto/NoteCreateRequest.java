package com.ginkgooai.core.mcp.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Request object for creating a new note")
public class NoteCreateRequest {
    
    private String content;
}