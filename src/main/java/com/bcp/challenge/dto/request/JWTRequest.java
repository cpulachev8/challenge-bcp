package com.bcp.challenge.dto.request;

import lombok.Data;

@Data
public class JWTRequest {

    private String username;
    private String password;
}
