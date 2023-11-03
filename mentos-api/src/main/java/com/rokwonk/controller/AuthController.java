package com.rokwonk.controller;

import com.rokwonk.common.annotation.RequestUser;
import com.rokwonk.dto.internal.UserInfo;
import com.rokwonk.dto.request.AuthEmailRequest;
import com.rokwonk.dto.request.AuthVerifyRequest;
import com.rokwonk.dto.request.LoginRequest;
import com.rokwonk.dto.response.SimpleResponse;
import com.rokwonk.dto.response.TokenResponse;
import com.rokwonk.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> signUpOrSignIn(@RequestBody LoginRequest request) {
        TokenResponse tokenResponse = authService.loginOrSignUp(request);
        return ResponseEntity.ok(tokenResponse);
    }

    @PostMapping("/email")
    public ResponseEntity<SimpleResponse> emailAuthenticate(
        @RequestUser UserInfo requestUser,
        @RequestBody AuthEmailRequest request
    ) {
        return ResponseEntity.ok(new SimpleResponse(200, "이메일 발송 성공"));
    }

    @PostMapping("/verify")
    public ResponseEntity<SimpleResponse> verifyAuthentication(
        @RequestUser UserInfo requestUser,
        @RequestBody AuthVerifyRequest request
    ) {
        return ResponseEntity.ok(new SimpleResponse(200, "성공"));
    }
}
