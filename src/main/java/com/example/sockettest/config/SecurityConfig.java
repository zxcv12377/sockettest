package com.example.sockettest.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/assets/**", "/css/**", "/js/**", "/upload/**").permitAll()
                        .requestMatchers("/movie/list", "/movie/read").permitAll()
                        .requestMatchers("/reviews/**", "/upload/display/**").permitAll()
                        .requestMatchers("/member/register").permitAll()
                        .requestMatchers("/api/**", "/ws/**").permitAll() // WebSocket 허용
                        .anyRequest().permitAll());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        http.csrf(csrf -> csrf.disable());

        // http.formLogin(login -> login.loginPage("/member/login")
        // .defaultSuccessUrl("/")
        // .permitAll());

        // http.logout(logout -> logout
        // .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
        // .logoutSuccessUrl("/"));

        // http.rememberMe(remember -> remember.rememberMeServices(rememberMeServices));

        return http.build();
    }

    @Bean // CORS 설정 메소드 추가
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(List.of("*")); // 또는 정확히 "http://localhost:5173"
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true); // 쿠키를 사용하는 경우 true

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean // = new 한 후 스프링 컨테이너가 관리
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // @Bean
    // CustomLoginSuccessHandler successHandler() {
    // return new CustomLoginSuccessHandler();
    // }

    // @Bean
    // RememberMeServices rememberMeServices(UserDetailsService userDetailsService)
    // {
    // RememberMeTokenAlgorithm encodingAlgorithm = RememberMeTokenAlgorithm.SHA256;
    // TokenBasedRememberMeServices rememberMeServices = new
    // TokenBasedRememberMeServices("myKey",
    // userDetailsService, encodingAlgorithm);
    // rememberMeServices.setMatchingAlgorithm(RememberMeTokenAlgorithm.MD5);
    // rememberMeServices.setTokenValiditySeconds(60 * 60 * 24 * 7);
    // return rememberMeServices;
    // }

}
