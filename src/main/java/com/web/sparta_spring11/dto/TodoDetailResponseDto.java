package com.web.sparta_spring11.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoDetailResponseDto {

    private final Long id;
    private final String todo;
    private final String name;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public TodoDetailResponseDto(Long id, String todo, String name, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.todo = todo;
        this.name = name;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
