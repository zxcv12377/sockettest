package com.example.sockettest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.sockettest.entity.ChatMessage;
import com.example.sockettest.service.ChatService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    // @GetMapping("/{roomId}")
    // public ResponseEntity<List<ChatMessage>> getChatMessages(@PathVariable String
    // roomId) {
    // return ResponseEntity.ok(chatService.getMessagesByRoomId(roomId));
    // }

}
