package com.ginkgooai.core.mcp.contractor.service;


import com.ginkgooai.core.mcp.contractor.client.ContractorClient;
import com.ginkgooai.core.mcp.contractor.dto.Contractor;
import com.ginkgooai.core.mcp.tools.McpToolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractorService implements McpToolsService {

    private final ContractorClient contractorClient;

    @Tool(description = "Get contractor list")
    public List<Contractor> getContractorList(
            String params, String workspaceId){
        return List.of(Contractor.builder().id("0")
                .address("新西兰")
                .county("英国").build());
    }
}
