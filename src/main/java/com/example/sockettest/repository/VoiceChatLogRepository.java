package com.example.sockettest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sockettest.entity.Member;
import com.example.sockettest.entity.VoiceChannel;
import com.example.sockettest.entity.VoiceChatLog;
import java.util.List;

public interface VoiceChatLogRepository extends JpaRepository<VoiceChatLog, Long> {

    List<VoiceChatLog> findByChannel(VoiceChannel channel);

    List<VoiceChatLog> findByMember(Member member);
}
