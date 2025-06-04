package com.example.sockettest.dto.voiceChat;

import com.example.sockettest.entity.VoiceChat.VoiceChannel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VoiceChannelDto {
    private Long id;
    private String name;
    private String description;
    private int maxParticipants;

    public static VoiceChannelDto from(VoiceChannel channel) {
        return VoiceChannelDto.builder()
                .id(channel.getId())
                .name(channel.getName())
                .description(channel.getDescription())
                .maxParticipants(channel.getMaxParticipants())
                .build();
    }

    public VoiceChannel toEntity() {
        return VoiceChannel.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .maxParticipants(this.maxParticipants)
                .build();
    }
}
