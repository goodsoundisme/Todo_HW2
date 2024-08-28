package com.sparta.todo_hw2.repository;

import com.sparta.todo_hw2.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);
}
