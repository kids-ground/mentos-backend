package com.rokwonk.dto.request;

public record LoginRequest(
        LoginType loginType,
        String token
) {
}
