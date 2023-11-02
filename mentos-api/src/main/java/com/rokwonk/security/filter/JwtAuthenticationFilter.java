package com.rokwonk.security.filter;

import com.rokwonk.security.provider.AuthenticationTokenProvider;
import com.rokwonk.service.JwtTokenService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Pattern AUTHORIZATION_PATTERN = Pattern.compile("^[Bb]earer (.*)$");
    private static final String AUTHORIZATION_HEADER = "Authorization";

    private final JwtTokenService jwtTokenService;
    private final AuthenticationTokenProvider authenticationTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader(AUTHORIZATION_HEADER);

        // 토큰 없으면 패스
        if (authorization == null || authorization.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }

        Matcher matcher = AUTHORIZATION_PATTERN.matcher(authorization);

        if (matcher.matches()) {
            String accessToken = authorization.substring(7);
            Boolean isVerifiedToken = jwtTokenService.verifyToken(accessToken);

            if (isVerifiedToken) {
                Claims jwtBody = jwtTokenService.extractClaims(accessToken);
                Authentication authenticationToken = authenticationTokenProvider.getAuthenticationToken(jwtBody);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
