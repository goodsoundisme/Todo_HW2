package com.sparta.todo_hw2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Todo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String contents;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    public Todo( String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    public void update(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
