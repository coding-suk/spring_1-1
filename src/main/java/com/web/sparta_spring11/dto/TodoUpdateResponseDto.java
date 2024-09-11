package com.web.sparta_spring11.dto;

import lombok.Getter;

@Getter
public class TodoUpdateResponseDto {

    private final Long id;
    private final String todo;
    private final String name;

    public TodoUpdateResponseDto(Long id, String todo, String name) {
        this.id = id;
        this.todo = todo;
        this.name = name;
    }
}
