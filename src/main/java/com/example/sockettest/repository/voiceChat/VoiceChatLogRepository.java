package com.example.sockettest.repository.voiceChat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sockettest.entity.VoiceChatLog;
import com.example.sockettest.entity.VoiceChat.Member;
import com.example.sockettest.entity.VoiceChat.VoiceChannel;

import java.util.List;

public interface VoiceChatLogRepository extends JpaRepository<VoiceChatLog, Long> {

    List<VoiceChatLog> findByChannel(VoiceChannel channel);

    List<VoiceChatLog> findByMember(Member member);
}
