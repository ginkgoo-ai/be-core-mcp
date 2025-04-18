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

    @Schema(description = "The address of the contractor, street + city + state", example = "P O BOX 1027,SAN CARLOS,CA", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String address;
    @Schema(description = "The classifications of the contractor", example = "C10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private List<String> classifications;
    @Schema(description = "The radius of the contractor, meter as unit, default value 80467.2 meters", defaultValue = "80467.2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Double radius;

}
