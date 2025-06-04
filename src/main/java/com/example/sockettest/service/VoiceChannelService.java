package com.example.sockettest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.sockettest.dto.voiceChat.VoiceChannelDto;
import com.example.sockettest.entity.VoiceChat.VoiceChannel;
import com.example.sockettest.repository.voiceChat.VoiceChannelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoiceChannelService {
    private final VoiceChannelRepository repository;

    public VoiceChannelDto createChannel(VoiceChannelDto dto) {
        VoiceChannel saved = repository.save(dto.toEntity());
        return VoiceChannelDto.from(saved);
    }

    public List<VoiceChannelDto> getAllChannels() {
        return repository.findAll().stream()
                .map(VoiceChannelDto::from)
                .collect(Collectors.toList());
    }

    public VoiceChannelDto getChannel(Long id) {
        return repository.findById(id)
                .map(VoiceChannelDto::from)
                .orElse(null);
    }

    public void deleteChannel(Long id) {
        repository.deleteById(id);
    }
}
