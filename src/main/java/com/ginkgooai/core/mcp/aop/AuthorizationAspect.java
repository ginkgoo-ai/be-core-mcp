package com.ginkgooai.core.mcp.aop;

import com.ginkgooai.core.common.utils.ContextUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizationAspect {

    @Before("@annotation(org.springframework.ai.tool.annotation.Tool) && args(params,workspaceId,..)")
    public void setAuthorizationBefore(String params, String workspaceId) {
        ContextUtils.get().put(HttpHeaders.AUTHORIZATION, params);
        ContextUtils.get().put("x-workspace-id", workspaceId);
    }
}