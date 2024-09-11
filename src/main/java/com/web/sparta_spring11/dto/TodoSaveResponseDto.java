package com.web.sparta_spring11.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSaveResponseDto {

    private final String todo;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoSaveResponseDto(String todo, String name,, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.todo = todo;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
