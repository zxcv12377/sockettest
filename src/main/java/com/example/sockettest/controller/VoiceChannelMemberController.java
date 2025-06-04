package com.example.sockettest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sockettest.dto.SpeakingStatusRequest;
import com.example.sockettest.dto.VoiceChannelJoinRequest;
import com.example.sockettest.entity.Member;
import com.example.sockettest.entity.VoiceChannel;
import com.example.sockettest.service.VoiceChannelMemberService;
import com.example.sockettest.service.VoiceChatLogService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/voice")
public class VoiceChannelMemberController {
    private final VoiceChannelMemberService voiceService;
    private final VoiceChatLogService logService;

    @PostMapping("/join")
    public void join(@RequestBody VoiceChannelJoinRequest request) {
        Member member = Member.builder().id(request.getMemberId()).build();
        VoiceChannel channel = VoiceChannel.builder().id(request.getChannelId()).build();
        voiceService.joinChannel(member, channel);
        logService.log(member, channel, "join", false);
    }

    @PostMapping("/leave")
    public void leave(@RequestBody VoiceChannelJoinRequest request) {
        Member member = Member.builder().id(request.getMemberId()).build();
        VoiceChannel channel = VoiceChannel.builder().id(request.getChannelId()).build();
        voiceService.leaveChannel(member, channel);
        logService.log(member, channel, "leave", false);
    }

    @GetMapping("/count/{ChannelId}")
    public Long count(@PathVariable Long ChannelId) {
        VoiceChannel channel = VoiceChannel.builder().id(ChannelId).build();
        return voiceService.getCurrentParticipantCount(channel);
    }

    @PostMapping("/speaking")
    public void setSpeaking(@RequestBody SpeakingStatusRequest request) {
        Member member = Member.builder().id(request.getMemberId()).build();
        VoiceChannel channel = VoiceChannel.builder().id(request.getChannelId()).build();
        voiceService.updateSpeakingStatus(member, channel, request.isSpeaking());
    }

}
