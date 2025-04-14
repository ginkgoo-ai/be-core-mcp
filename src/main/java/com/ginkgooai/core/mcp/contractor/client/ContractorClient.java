package com.ginkgooai.core.mcp.contractor.client;

import com.ginkgooai.core.common.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Contractor-service-application", url="${core-contractor-uri}", configuration = FeignConfig.class)
public interface ContractorClient {

}

