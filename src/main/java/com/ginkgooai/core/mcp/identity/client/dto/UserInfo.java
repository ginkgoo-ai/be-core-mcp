package com.ginkgooai.core.mcp.identity.client.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserInfo {
    private String id;
    
    private String sub;
    
    private String email;
    
    private String firstName;
    
    private String lastName;
    
    private boolean enabled;
    
    private Set<String> roles;
}

