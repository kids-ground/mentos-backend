package com.rokwonk.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rokwonk.client.AppleClient;
import com.rokwonk.client.KakaoClient;
import com.rokwonk.dto.internal.AppleJwtBodyInfo;
import com.rokwonk.dto.request.LoginRequest;
import com.rokwonk.dto.request.LoginType;
import com.rokwonk.dto.response.AppleAuthKeysResponse;
import com.rokwonk.dto.response.KakaoUserInfoResponse;
import com.rokwonk.dto.response.TokenResponse;
import com.rokwonk.exception.inavlid.InvalidApplePublicKeyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PublicKey;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    private final ObjectMapper objectMapper;
    private final OpenIdVerifyService openIdVerifyService;
    private final JwtTokenService jwtTokenService;
    private final MemberService memberService;

    private final AppleClient appleClient;
    private final KakaoClient kakaoClient;

    public TokenResponse loginOrSignUp(LoginRequest request) {
        log.info("GET!");
        LoginType oauthType = request.loginType();
        String uniqueId = switch (oauthType) {
            case KAKAO -> getKakaoUniqueUserId(request.token());
            case APPLE -> getAppleUniqueUserId(request.token());
        };

        log.info("유저 정보 체크");

        Long memberId = memberService.getMemberByOAuth(oauthType, uniqueId).orElse(null);
        Boolean isSignup = memberId == null;
        if (memberId == null) memberId = memberService.createMember(oauthType, uniqueId);
        String accessToken = jwtTokenService.createToken(memberId);

        return new TokenResponse(accessToken, "", isSignup);
    }

    private String getAppleUniqueUserId(String identityToken) {
        AppleAuthKeysResponse authKeys = appleClient.getAuthKeys();
        String jwtHeaderString = jwtTokenService.extractJwtHeaderString(identityToken);
        PublicKey publicKey = openIdVerifyService.getApplePublicKey(jwtHeaderString, authKeys);
        Boolean isVerified  = jwtTokenService.verifyToken(identityToken, publicKey);

        if (!isVerified) throw new InvalidApplePublicKeyException();

        try {
            String jwtBodyString = jwtTokenService.extractJwtBodyString(identityToken);
            AppleJwtBodyInfo jwtBody = objectMapper.readValue(jwtBodyString, AppleJwtBodyInfo.class);
            return jwtBody.getSub();
        } catch(JsonProcessingException e) {
            throw new InvalidApplePublicKeyException();
        }
    }

    private String getKakaoUniqueUserId(String accessToken) {
        KakaoUserInfoResponse userInfo = kakaoClient.getUserProfile("Bearer " + accessToken);
        return userInfo.getId().toString();
    }
}
