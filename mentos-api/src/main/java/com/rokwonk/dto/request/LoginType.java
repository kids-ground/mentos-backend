package com.rokwonk.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.rokwonk.member.vo.MemberOAuthType;

public enum LoginType {
    KAKAO, APPLE;

    @JsonCreator
    public static LoginType from(String value) {
        return LoginType.valueOf(value);
    }

    public MemberOAuthType toOAuthType() {
        switch (this) {
            case APPLE:
                return MemberOAuthType.APPLE;
            case KAKAO:
                return MemberOAuthType.KAKAO;
        }
        return null;
    }
}
