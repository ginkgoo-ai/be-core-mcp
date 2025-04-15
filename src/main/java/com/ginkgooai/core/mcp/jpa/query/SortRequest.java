package com.ginkgooai.core.mcp.jpa.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SortRequest {
    /**
     * Order by
     */

    @Schema(description = "Sort field", example = "createdDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    protected String sortField;

    /**
     * Order type
     */

    @Schema(description = "Sort direction", example = "ASC")
    protected OrderType sortDirection;
}
