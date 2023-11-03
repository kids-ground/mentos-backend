package com.rokwonk.client;

import com.rokwonk.dto.response.KakaoUserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "kakao", url = "${feign.kakao.url}")
public interface KakaoClient {
    @GetMapping("/v2/user/me")
    public KakaoUserInfoResponse getUserProfile(@RequestHeader("Authorization") String accessToken);
}