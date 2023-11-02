package com.rokwonk.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum LoginType {
    KAKAO, APPLE;

    @JsonCreator
    public static LoginType from(String value) {
        return LoginType.valueOf(value);
    }
}
