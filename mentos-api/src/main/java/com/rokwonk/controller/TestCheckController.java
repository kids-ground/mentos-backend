package com.rokwonk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TestCheckController {
    @GetMapping("/health-check")
    public String home() {
        return "Health Check for ECS!";
    }

    @GetMapping("/test/network")
    public String network() {
        return "네트워크 수업 - 김록원 개인 도메인";
    }
}
