package com.example.sockettest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sockettest.entity.VoiceChannelMember;
import com.example.sockettest.entity.VoiceChannel;
import java.util.List;

@Repository
public interface VoiceChannelMemberRepository extends JpaRepository<VoiceChannelMember, Long> {
    long countByChannel(VoiceChannel channel);

    List<VoiceChannelMember> findByChannel(VoiceChannel channel);
}
