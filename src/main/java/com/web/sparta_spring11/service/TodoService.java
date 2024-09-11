package com.web.sparta_spring11.service;

import com.web.sparta_spring11.dto.*;
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
        Todo newTodo = new Todo(requestDto.getTodo(), requestDto.getName(), requestDto.getPw()); // 엔티티로 변환해서 전잘

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

    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto requestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("할일이 없어요"));

        todo.update(requestDto.getTodo(), requestDto.getName());
        return new TodoUpdateResponseDto(todo.getId(), todo.getTodo(), todo.getName());
    }

    public void deleteTodo(Long todoId, TodoDeletRequestDto requestDto) {
        String password = requestDto.getPw();
        if(password == null) {
            throw new NullPointerException("비밀번호가 없음");
        }

        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("할일이 없어요"));

        if(!password.equals(todo.getPw())) {
            throw new RuntimeException("비번이 틀립니다");
        }
//        ObjectUtils.nullSafeEquals(todo.getPw(), requestDto.getPw()); //?

        todoRepository.delete(todo);
        // 마지막 삭제 부분이 잘 모르겠음

    }
}
