package com.web.sparta_spring11.controller;

import com.web.sparta_spring11.dto.TodoDetailResponseDto;
import com.web.sparta_spring11.dto.TodoSaveRequestDto;
import com.web.sparta_spring11.dto.TodoSaveResponseDto;
import com.web.sparta_spring11.dto.TodoSimpleResponseDto;
import com.web.sparta_spring11.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public TodoSaveResponseDto saveTodo(@RequestBody TodoSaveRequestDto requestDto) {
        return todoService.saveTodo(requestDto);
    }

    //선택한 일정 조회(특정한 일정)
    @GetMapping("/todos/{todoId}")
    public TodoDetailResponseDto detailTodo(@PathVariable Long todoId) {
        return todoService.detailTodo(todoId);
    }

    //전부 조회
    @GetMapping("/todos")
    public List<TodoSimpleResponseDto> getTodo(@RequestParam(required = true) String date) {
        return todoService.getTodos(date);
    }

    //수정
    @PutMapping("/todos/{todoId}")
    public TodoUpdateResponseDto updateTodo(@Path)

}
