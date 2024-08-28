package com.sparta.todo_hw2.controller;

import com.sparta.todo_hw2.dto.Todo.request.TodoSaveRequestDto;
import com.sparta.todo_hw2.dto.Todo.request.TodoUpdateRequestDto;
import com.sparta.todo_hw2.dto.Todo.response.TodoSaveResponseDto;
import com.sparta.todo_hw2.dto.Todo.response.TodoSimpleResponsDto;
import com.sparta.todo_hw2.dto.Todo.response.TodoUpdateResponseDto;
import com.sparta.todo_hw2.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoSaveResponseDto> saveTodo(@RequestBody TodoSaveRequestDto todoSaveRequestDto) {
        return ResponseEntity.ok(todoService.saveTodo(todoSaveRequestDto));
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<TodoSimpleResponsDto>> getTodos(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(todoService.getTodos(page, size));
    }

    @PutMapping("/todos/{todoId}")
    public ResponseEntity<TodoUpdateResponseDto> updateTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequestDto todoUpdateRequestDto) {
        return ResponseEntity.ok(todoService.updateTodo(todoId, todoUpdateRequestDto));
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) { todoService.deleteTodo(todoId);
    }
}
