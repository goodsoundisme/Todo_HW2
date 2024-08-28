package com.sparta.todo_hw2.repository;

import com.sparta.todo_hw2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
