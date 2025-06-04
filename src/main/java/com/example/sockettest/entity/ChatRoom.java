package com.example.sockettest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String name; // 채팅방 이름 (중복불가) 가능여부는 나중에

    private String description; // 방 설명

    private int maxParticipants; // 채널 최대 인원

    // 채널에 접속해 있는 인원 (양방향)
    @OneToMany(mappedBy = "channel")
    private List<ChannelMember> members;

    @OneToMany(mappedBy = "channel")
    private List<VoiceChatLog> logs;
    // (양방향 옵션)
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<ChatMessageEntity> messages;

    // 채널 타입 (TEXT, VOICE)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChannelType type; // TEXT, VOICE

    // 채널이 속한 서버 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "server_id", nullable = false)
    private Server server;
}
