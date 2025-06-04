package com.example.sockettest.repository;

import com.example.sockettest.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {

}
