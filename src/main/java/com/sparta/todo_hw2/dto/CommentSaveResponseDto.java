package com.sparta.todo_hw2.dto;

import lombok.Getter;

@Getter

public class CommentSaveResponseDto {
    private final Long id;
    private final String contents;

    public CommentSaveResponseDto(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }
}
