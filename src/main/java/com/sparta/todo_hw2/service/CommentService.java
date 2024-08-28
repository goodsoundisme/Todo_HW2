package com.sparta.todo_hw2.service;

import com.sparta.todo_hw2.dto.comment.response.CommentResponseDto;
import com.sparta.todo_hw2.dto.comment.request.CommentSaveRequestDto;
import com.sparta.todo_hw2.dto.comment.response.CommentSaveResponseDto;
import com.sparta.todo_hw2.entity.Comment;
import com.sparta.todo_hw2.entity.Todo;
import com.sparta.todo_hw2.repository.CommentRepository;
import com.sparta.todo_hw2.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long todoId, CommentSaveRequestDto commentSaveRequestDto) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("todo가 없어요"));

        Comment comment = new Comment(commentSaveRequestDto.getContents(), todo);
        Comment savedComment = commentRepository.save(comment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getContents());
    }
    public List<CommentResponseDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentResponseDto(comment.getId(), comment.getContents()));
        }
        return dtoList;
    }
}
