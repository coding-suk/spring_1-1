package com.web.sparta_spring11.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Todo extends Timestamped{

    @Id
    @GeneratedValue
    private Long id;
    private String todo;
    private String name;
    private String pw;

    public Todo(String todo, String name, String pw) {
        this.todo = todo;
        this.name = name;
        this.pw = pw;
    }
}
