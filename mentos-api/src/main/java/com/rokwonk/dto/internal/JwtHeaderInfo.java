package com.rokwonk.dto.internal;

import lombok.Getter;

@Getter
public class JwtHeaderInfo {
    private String kid;
    private String alg;
}

