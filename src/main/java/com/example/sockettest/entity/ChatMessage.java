package com.example.sockettest.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO도 가능
    private Long id;

    private String memberid; // sender
    private String message;
    private Long roomId;
    // private Room room;
    // private Member Sender;

    @Builder.Default
    private LocalDateTime sendAt = LocalDateTime.now();
}