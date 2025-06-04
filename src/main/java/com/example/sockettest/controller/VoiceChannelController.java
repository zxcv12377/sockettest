package com.example.sockettest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sockettest.dto.voiceChat.VoiceChannelDto;
import com.example.sockettest.service.VoiceChannelService;
import com.example.sockettest.service.VoiceChatLogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/channels")
@RequiredArgsConstructor
public class VoiceChannelController {
    private final VoiceChannelService service;

    @PostMapping("")
    public VoiceChannelDto create(@RequestBody VoiceChannelDto dto) {
        return service.createChannel(dto);
    }

    @GetMapping("")
    public List<VoiceChannelDto> getAll() {
        return service.getAllChannels();
    }

    @GetMapping("/{id}")
    public VoiceChannelDto getOne(@PathVariable Long id) {
        return service.getChannel(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteChannel(id);
    }
}
