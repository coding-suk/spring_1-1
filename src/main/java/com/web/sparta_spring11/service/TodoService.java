package com.web.sparta_spring11.service;

import com.web.sparta_spring11.dto.TodoDetailResponseDto;
import com.web.sparta_spring11.dto.TodoSaveRequestDto;
import com.web.sparta_spring11.dto.TodoSaveResponseDto;
import com.web.sparta_spring11.dto.TodoSimpleResponseDto;
import com.web.sparta_spring11.entity.Todo;
import com.web.sparta_spring11.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto requestDto) {
        Todo newTodo = new Todo(requestDto.getTodo(), requestDto.getName(), requestDto.getPw());

        Todo savedTodo = todoRepository.save(newTodo);
        return new TodoSaveResponseDto(
                savedTodo.getTodo(), savedTodo.getName(), savedTodo.getCreatedAt(), savedTodo.getModifiedAt());
    }

    public TodoDetailResponseDto detailTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("할일이 없어요"));

        return new TodoDetailResponseDto(
                todo.getId(), todo.getTodo(), todo.getName(), todo.getModifiedAt(), todo.getModifiedAt());
    }

    public List<TodoSimpleResponseDto> getTodos(String date) {

        //LocalDate를 LocalDateTime으로 변환
        LocalDateTime startDateTime = LocalDate.parse(date).atStartOfDay();
        LocalDateTime endDateTime = LocalDate.parse(date).atTime(LocalTime.MAX);

        List<Todo> todoList = todoRepository.findAllByCreatedAtBetweenOrderByModifiedAtDesc(startDateTime, endDateTime);

        List<TodoSimpleResponseDto> dtoList = new ArrayList<>();

        for (Todo todo : todoList) {
            TodoSimpleResponseDto dto = new TodoSimpleResponseDto(
                    todo.getId(), todo.getTodo(), todo.getName(), todo.getCreatedAt(), todo.getModifiedAt());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
