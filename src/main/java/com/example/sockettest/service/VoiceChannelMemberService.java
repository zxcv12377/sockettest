package com.example.sockettest.service;

import org.springframework.stereotype.Service;

import com.example.sockettest.entity.VoiceChat.Member;
import com.example.sockettest.entity.VoiceChat.VoiceChannel;
import com.example.sockettest.entity.VoiceChat.VoiceChannelMember;
import com.example.sockettest.repository.voiceChat.VoiceChannelMemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VoiceChannelMemberService {
    private final VoiceChannelMemberRepository voiceChannelMemberRepository;

    public void joinChannel(Member member, VoiceChannel channel) {
        VoiceChannelMember entry = VoiceChannelMember.builder()
                .member(member)
                .channel(channel)
                .speaking(false)
                .build();
        voiceChannelMemberRepository.save(entry);
    }

    public void leaveChannel(Member member, VoiceChannel channel) {
        voiceChannelMemberRepository.findByChannel(channel).stream()
                .filter(vcm -> vcm.getMember().getId().equals(member.getId()))
                .findFirst()
                .ifPresent(voiceChannelMemberRepository::delete);
    }

    public long getCurrentParticipantCount(VoiceChannel channel) {
        return voiceChannelMemberRepository.countByChannel(channel);
    }

    public void updateSpeakingStatus(Member member, VoiceChannel channel, boolean speaking) {
        voiceChannelMemberRepository.findByChannel(channel).stream()
                .filter(vcm -> vcm.getMember().getId().equals(member.getId()))
                .findFirst()
                .ifPresent(vcm -> {
                    vcm.changeSpeaking(speaking);
                    voiceChannelMemberRepository.save(vcm);
                });
    }
}
