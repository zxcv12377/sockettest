package com.example.sockettest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sockettest.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
