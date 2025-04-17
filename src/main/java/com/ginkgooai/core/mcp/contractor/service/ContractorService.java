package com.ginkgooai.core.mcp.contractor.service;


import com.ginkgooai.core.mcp.contractor.client.ContractorClient;
import com.ginkgooai.core.mcp.contractor.dto.Contractor;
import com.ginkgooai.core.mcp.contractor.dto.request.QueryContractorRequest;
import com.ginkgooai.core.mcp.jpa.query.PaginationRequest;
import com.ginkgooai.core.mcp.jpa.query.SortRequest;
import com.ginkgooai.core.mcp.tools.McpToolsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContractorService implements McpToolsService {

    private final ContractorClient contractorClient;

    @Tool(description = "Get contractor list")
    public Page<Contractor> getContractorList(
            @ToolParam QueryContractorRequest queryContractorRequest,
            @ToolParam PaginationRequest paginationRequest,
            @ToolParam SortRequest sortRequest) {

        log.info("queryContractorRequest: {}", queryContractorRequest);
        log.info("paginationRequest: {}", paginationRequest);
        log.info("sortRequest: {}", sortRequest);
        if (queryContractorRequest.getAddress() != null && queryContractorRequest.getRadius() == null) {
            queryContractorRequest.setRadius(80467.2);
        }

        if(!CollectionUtils.isEmpty(queryContractorRequest.getClassifications())){
            List<String> list = queryContractorRequest.getClassifications().stream().map(contractor -> contractor.replaceAll("-", "")).toList();
            queryContractorRequest.setClassifications(list);
        }

        return contractorClient.query(queryContractorRequest, paginationRequest, sortRequest);
    }
}
