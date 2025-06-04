package com.example.sockettest.entity.VoiceChat;

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

// 채널에 현재 접속 중인 사용자 목록 관리
@Getter
@Builder
@ToString(exclude = { "member", "channel" })
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VoiceChannelMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private VoiceChannel channel;

    // private boolean muted; // 필요시 추가
    private boolean speaking;

    public void changeSpeaking(boolean speaking) {
        this.speaking = speaking;
    }
}
