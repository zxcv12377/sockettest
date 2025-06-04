package com.example.sockettest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.example.sockettest.websoket.JwtHandshakeInterceptor;

import lombok.RequiredArgsConstructor;

@EnableWebSocketMessageBroker
@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements /* WebSocketConfigurer, */ WebSocketMessageBrokerConfigurer {

    private final JwtHandshakeInterceptor jwtHandshakeInterceptor;

    // private final ChatHandler chatHandler;

    // public WebSocketConfig(ChatHandler signalingHandler) {
    // this.chatHandler = signalingHandler;
    // }

    // @Override
    // public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

    // registry.addHandler(chatHandler, "/ws/chat")
    // .setAllowedOrigins("*");
    // }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableStompBrokerRelay("/topic") // 채팅방 등 메시지 송신용
                .setRelayHost("localhost") // Redis 호스트
                .setRelayPort(61613) // Redis STOMP 포트
                .setClientLogin("guest") // Redis나 RabbitMQ 브로커 계정
                .setClientPasscode("guest"); // Redis나 RabbitMQ 브로커 계정

        registry.setApplicationDestinationPrefixes("/app"); // 클라이언트 전송 prefix
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")
                .addInterceptors(jwtHandshakeInterceptor) // JWT 인증 인터셉터
                .withSockJS();
    }
}