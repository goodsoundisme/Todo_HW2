package com.sparta.todo_hw2.controller;

import com.sparta.todo_hw2.dto.CommentResponseDto;
import com.sparta.todo_hw2.dto.CommentSaveRequestDto;
import com.sparta.todo_hw2.dto.CommentSaveResponseDto;
import com.sparta.todo_hw2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public CommentSaveResponseDto saveComment(@PathVariable Long todoId, @RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return commentService.saveComment(todoId, commentSaveRequestDto);
    }

    @GetMapping("/todos/comments")
    public List<CommentResponseDto> getComments() {
        return commentService.getComments();
    }
}
