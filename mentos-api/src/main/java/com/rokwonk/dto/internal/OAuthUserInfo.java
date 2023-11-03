package com.rokwonk.dto.internal;

import com.rokwonk.dto.request.LoginType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OAuthUserInfo {
    private String id;
    private LoginType oauthType;
}
