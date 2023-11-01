package com.rokwonk.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors();
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.formLogin().disable();
        http.httpBasic().disable();

//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, authenticationTokenProvider), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new AuthenticationExceptionFilter(objectMapper), JwtAuthenticationFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(new RestAuthenticationEntryPoint());

        http
                .authorizeHttpRequests( request -> request
                        .requestMatchers(
                            "/v2/api-docs",
                            "/swagger-resources",
                            "/swagger-resources/**",
                            "/configuration/ui",
                            "/configuration/security",
                            "/swagger-ui.html",
                            "/webjars/**",
                            /* swagger v3 */
                            "/v3/api-docs/**",
                            "/swagger-ui/**"
                        ).permitAll()
                )
                .authorizeHttpRequests( request -> request
                        .requestMatchers(
                            "/test/*",
                                "/auth/login"
                        ).permitAll()
                )
                .authorizeHttpRequests(request -> request
                        .anyRequest()
                        .authenticated()
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOriginPatterns(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "POST", "GET", "DELETE", "PUT", "PATCH", "OPTIONS"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);
        return configurationSource;
    }
}
