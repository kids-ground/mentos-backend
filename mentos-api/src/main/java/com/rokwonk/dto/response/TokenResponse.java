package com.rokwonk.dto.response;

public record TokenResponse(
        String accessToken,
        String refreshToken,
        Boolean isSignup
) {
}
