package com.example.sockettest.repository.voiceChat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sockettest.entity.VoiceChat.VoiceChannel;
import com.example.sockettest.entity.VoiceChat.VoiceChannelMember;

import java.util.List;

@Repository
public interface VoiceChannelMemberRepository extends JpaRepository<VoiceChannelMember, Long> {
    long countByChannel(VoiceChannel channel);

    List<VoiceChannelMember> findByChannel(VoiceChannel channel);
}
