package com.example.sockettest.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.sockettest.entity.ChatMessage;
import com.example.sockettest.repository.ChatMessageRepository;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatMessageRepository chatMessageRepository;

    public ChatMessage save(ChatMessage message) {
        return chatMessageRepository.save(message);
    }

    public List<ChatMessage> getMessagesByRoomId(Long roomId) {
        return chatMessageRepository.findByRoomIdOrderBySendAtAsc(roomId);
    }

    // public void deleteMessageByRoomId(Long roomId) {
    // chatMessageRepository.deleteByRoomId(roomId);
    // }
}