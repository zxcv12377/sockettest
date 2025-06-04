package com.example.sockettest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sockettest.repository.voiceChat.VoiceChatLogRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class VoiceChatLogController {
    private final VoiceChatLogRepository voiceChatLogRepository;

    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

}
