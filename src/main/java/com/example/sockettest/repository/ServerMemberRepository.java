package com.example.sockettest.repository;

import com.example.sockettest.entity.ServerMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerMemberRepository extends JpaRepository<ServerMember, Long> {

}
