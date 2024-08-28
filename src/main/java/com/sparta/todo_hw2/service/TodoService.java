package com.sparta.todo_hw2.service;

import com.sparta.todo_hw2.dto.*;
import com.sparta.todo_hw2.entity.Todo;
import com.sparta.todo_hw2.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {
        Todo todo = new Todo(todoSaveRequestDto.getTitle(), todoSaveRequestDto.getContents());
        Todo savedTodo = todoRepository.save(todo);

        return new TodoSaveResponseDto(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getContents());
    }

    public List<TodoSimpleResponsDto> getTodos() {
        List<Todo> todoList = todoRepository.findAll();

        List<TodoSimpleResponsDto> dtoList = new ArrayList<>();
        for (Todo todo : todoList) {
            TodoSimpleResponsDto dto = new TodoSimpleResponsDto(todo.getId(), todo.getTitle(), todo.getContents());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("todo가 없어요"));
        todo.update(todoUpdateRequestDto.getTitle(), todoUpdateRequestDto.getContents());

        return new TodoUpdateResponseDto(todo.getId(), todo.getTitle(), todo.getContents());
    }


}
