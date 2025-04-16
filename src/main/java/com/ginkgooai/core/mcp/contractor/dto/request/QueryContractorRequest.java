package com.ginkgooai.core.mcp.contractor.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryContractorRequest{

    @Schema(description = "The address of the contractor", example = "123 Main St", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String address;
    @Schema(description = "The city of the contractor", example = "New York", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String city;
    @Schema(description = "The state of the contractor", example = "NY", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String state;
    @Schema(description = "The classifications of the contractor", example = "C10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private List<String> classifications;
    @Schema(description = "The radius of the contractor, meter as unit", example = "100", requiredMode = Schema.RequiredMode.NOT_REQUIRED, requiredProperties = {"address"})
    private Double radius;

}
