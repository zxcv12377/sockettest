package com.example.sockettest.repository.voiceChat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sockettest.entity.VoiceChat.VoiceChannel;

public interface VoiceChannelRepository extends JpaRepository<VoiceChannel, Long> {

}
