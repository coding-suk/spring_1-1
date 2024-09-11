package com.web.sparta_spring11.repository;

import com.web.sparta_spring11.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
//    List<Todo> findAllByCreatedAtBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Todo> findAllByCreatedAtBetweenOrderByModifiedAtDesc(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
