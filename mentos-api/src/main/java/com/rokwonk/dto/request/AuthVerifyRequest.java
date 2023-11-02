package com.rokwonk.dto.request;

public record AuthVerifyRequest(
        AuthVerifyType authVerifyType,
        Integer verifyNumber
) {
}
