package com.rokwonk.security.provider;

import com.rokwonk.dto.internal.UserInfo;
import com.rokwonk.security.token.JwtAuthenticationToken;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthenticationTokenProvider {
    public Authentication getAuthenticationToken(Claims claims) {
        Long memberId = claims.get("memberId", Long.class);
        List<GrantedAuthority> authorities  = Arrays.stream(claims.get("role", String.class).split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new JwtAuthenticationToken(new UserInfo(memberId), "", authorities);
    }
}
