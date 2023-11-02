package com.rokwonk.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum AuthVerifyType {
    EMAIL;

    @JsonCreator
    public static AuthVerifyType from(String value) {
        return AuthVerifyType.valueOf(value);
    }
}
