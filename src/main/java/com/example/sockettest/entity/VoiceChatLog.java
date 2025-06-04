package com.example.sockettest.entity;

import java.time.LocalDateTime;

import com.example.sockettest.entity.VoiceChat.Member;
import com.example.sockettest.entity.VoiceChat.VoiceChannel;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString(exclude = { "channelId", "memberId" })
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VoiceChatLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private VoiceChannel channel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private boolean speaking;

    private String action;

    private LocalDateTime timestamp;
}
