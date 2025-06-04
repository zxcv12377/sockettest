package com.example.sockettest.controller.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.sockettest.dto.SpeakingStatusRequest;
import com.example.sockettest.entity.Member;
import com.example.sockettest.entity.VoiceChannel;
import com.example.sockettest.service.VoiceChannelMemberService;
import com.example.sockettest.service.VoiceChatLogService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SpeakingStatusSoketController {
    private final VoiceChannelMemberService voiceService;
    private final VoiceChatLogService logService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/voice/speaking")
    public void updateSpeakingStatus(SpeakingStatusRequest request) {
        Member member = Member.builder().id(request.getMemberId()).build();
        VoiceChannel channel = VoiceChannel.builder().id(request.getChannelId()).build();
        voiceService.updateSpeakingStatus(member, channel, request.isSpeaking());

        logService.log(
                member,
                channel,
                request.isSpeaking() ? "speak_start" : "speak_stop",
                request.isSpeaking());

        messagingTemplate.convertAndSend(
                "/topic/voice/" + request.getChannelId() + "/speaking", request);
    }
}
