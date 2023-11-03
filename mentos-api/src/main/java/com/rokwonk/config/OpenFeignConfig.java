package com.rokwonk.config;

import com.rokwonk.MentosApiApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = MentosApiApplication.class)
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class OpenFeignConfig {
}
