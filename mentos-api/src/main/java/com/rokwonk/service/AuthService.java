package com.rokwonk.service;

import com.rokwonk.dto.request.LoginRequest;
import com.rokwonk.dto.request.LoginType;
import com.rokwonk.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    @Transactional
    public TokenResponse loginOrSignUp(LoginRequest request) {
        return new TokenResponse("");
    }
}
