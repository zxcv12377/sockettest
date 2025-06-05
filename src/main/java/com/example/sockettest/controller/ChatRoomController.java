package com.example.sockettest.controller;

import com.example.sockettest.dto.ChatRoomResponseDTO;
import com.example.sockettest.entity.ChannelType;
import com.example.sockettest.entity.ChatRoom;
import com.example.sockettest.security.custom.GlobalExceptionHandler;
import com.example.sockettest.security.dto.MemberSecurityDTO;
import com.example.sockettest.service.ChatRoomService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chatrooms")
@RequiredArgsConstructor

public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    // 채널 생성
    @PostMapping
    public ChatRoomResponseDTO createRoom(
            @AuthenticationPrincipal MemberSecurityDTO member,
            @RequestBody Map<String, String> req) {

        String name = req.get("name");
        String description = req.get("description");
        Long serverId = Long.valueOf(req.get("serverId")); // ← 반드시 서버 ID 받아야 함
        ChannelType type = ChannelType.valueOf(req.getOrDefault("type", "TEXT"));
        return chatRoomService.createRoom(serverId, member.getMno(), name, description, type);
    }

    // 채널 목록 렌더링
    @GetMapping
    public List<ChatRoom> listRooms() {
        return chatRoomService.listRooms();
    }

    // 채널 삭제 (방장만 가능)
    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(
            @PathVariable Long roomId,
            @AuthenticationPrincipal MemberSecurityDTO member) {

        chatRoomService.deleteRoom(roomId, member.getMno());
        return ResponseEntity.noContent().build();
    }

}
