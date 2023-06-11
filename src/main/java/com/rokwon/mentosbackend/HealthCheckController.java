package com.rokwon.mentosbackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthCheckController {
    @GetMapping("/health-check")
    @ResponseBody
    public String home() {
        return "welcome mentos backend server~!!!";
    }
}