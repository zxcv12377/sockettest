package com.example.sockettest.service;

import com.example.sockettest.dto.ServerRequestDTO;
import com.example.sockettest.dto.ServerResponseDTO;
import com.example.sockettest.entity.Server;
import com.example.sockettest.entity.Member;
import com.example.sockettest.entity.ServerMember;
import com.example.sockettest.entity.ServerRole;
import com.example.sockettest.repository.ServerRepository;
import com.example.sockettest.repository.ServerMemberRepository;
import com.example.sockettest.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ServerService {

        private final ServerRepository serverRepository;
        private final ServerMemberRepository serverMemberRepository;
        private final MemberRepository memberRepository;

        @Transactional
        public ServerResponseDTO createServer(ServerRequestDTO dto, Long ownerId) {
                Member owner = memberRepository.findById(ownerId)
                                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));

                Server server = Server.builder()
                                .name(dto.getName())
                                .description(dto.getDescription())
                                .build();
                serverRepository.save(server);

                // 서버 개설자에게 ADMIN 권한 부여
                ServerMember serverMember = ServerMember.builder()
                                .member(owner)
                                .server(server)
                                .role(ServerRole.ADMIN)
                                .build();
                serverMemberRepository.save(serverMember);

                return ServerResponseDTO.from(server);
        }
}
