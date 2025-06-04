package com.example.sockettest.security.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT) // 409
public class DuplicateChatRoomException extends RuntimeException {
    public DuplicateChatRoomException(String message) {
        super(message);
    }

}
