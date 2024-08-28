package com.sparta.todo_hw2.dto.Todo.response;

import com.sparta.todo_hw2.dto.comment.response.CommentResponseDto;
import com.sparta.todo_hw2.entity.Comment;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class TodoSimpleResponsDto {
    private final Long id;
    private final String title;
    private final List<CommentResponseDto> comments;


    public TodoSimpleResponsDto(Long id, String title, List<Comment> comments) {
        List<CommentResponseDto> dtoList = new ArrayList<>();
        for(Comment comment : comments) {
            dtoList.add(new CommentResponseDto(comment.getId(),comment.getContents()));
        }
        this.id = id;
        this.title = title;
        this.comments = dtoList;
    }
}
