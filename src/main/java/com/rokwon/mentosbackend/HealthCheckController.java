package com.rokwon.mentosbackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthCheckController {
    @GetMapping("/health-check")
    @ResponseBody
    public String home() {
        return "Health Check with Pipeline!";
    }

    @GetMapping("/network")
    @ResponseBody
    public String network() {
        return "네트워크 수업 - 김록원 개인 도메인";
    }
}