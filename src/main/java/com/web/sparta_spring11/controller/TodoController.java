package com.web.sparta_spring11.controller;

import com.web.sparta_spring11.dto.*;
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
        TodoSaveResponseDto dto = todoService.saveTodo(requestDto);
        return todoService.saveTodo(requestDto); // 서비스는 비지니스 로직은 처리.
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
    @PutMapping("/todos/{todoId}")  // todos/2
    public TodoUpdateResponseDto updateTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequestDto requestDto) {
        return todoService.updateTodo(todoId, requestDto);
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId, @RequestBody TodoDeletRequestDto requestDto) {
        todoService.deleteTodo(todoId, requestDto);
    }
}
