package com.ginkgooai.core.mcp.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.ai.tool.annotation.ToolParam;

@Data
@Schema(description = "Request object for creating a new note")
public class NoteCreateRequest {

    @ToolParam(description = "Content of the note")
    private String content;
}