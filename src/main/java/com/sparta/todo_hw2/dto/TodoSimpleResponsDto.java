package com.sparta.todo_hw2.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;

@Getter

public class TodoSimpleResponsDto {
    private final Long id;
    private final String title;
    private final String comments;

    public TodoSimpleResponsDto(Long id, String title, String comments) {
        this.id = id;
        this.title = title;
        this.comments = comments;
    }
}
