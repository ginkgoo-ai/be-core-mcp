package com.ginkgooai.core.mcp.contractor.client;

import com.ginkgooai.core.common.config.FeignConfig;
import com.ginkgooai.core.mcp.contractor.dto.Contractor;
import com.ginkgooai.core.mcp.contractor.dto.request.QueryContractorRequest;
import com.ginkgooai.core.mcp.jpa.query.PaginationRequest;
import com.ginkgooai.core.mcp.jpa.query.SortRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Contractor-service-application", url="${core-contractor-uri}", configuration = FeignConfig.class)
public interface ContractorClient {

    @GetMapping("/contractors")
    Page<Contractor> query(@SpringQueryMap QueryContractorRequest queryContractorRequest,
                                  @SpringQueryMap PaginationRequest paginationRequest,
                                  @SpringQueryMap SortRequest sortRequest);
}

