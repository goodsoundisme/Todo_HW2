package com.sparta.todo_hw2.service;

import com.sparta.todo_hw2.dto.Todo.request.TodoSaveRequestDto;
import com.sparta.todo_hw2.dto.Todo.request.TodoUpdateRequestDto;
import com.sparta.todo_hw2.dto.Todo.response.TodoSaveResponseDto;
import com.sparta.todo_hw2.dto.Todo.response.TodoSimpleResponsDto;
import com.sparta.todo_hw2.dto.Todo.response.TodoUpdateResponseDto;
import com.sparta.todo_hw2.entity.Todo;
import com.sparta.todo_hw2.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<TodoSimpleResponsDto> getTodos(int page, int size) {
        Pageable pageable = PageRequest.of(page -1, size);

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(todo -> new TodoSimpleResponsDto(
                todo.getId(),
                todo.getTitle(),
                todo.getComments()
        ));

    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("todo가 없어요"));
        todo.update(todoUpdateRequestDto.getTitle(), todoUpdateRequestDto.getContents());

        return new TodoUpdateResponseDto(todo.getId(), todo.getTitle(), todo.getContents());
    }

    @Transactional
    public void deleteTodo(Long todoId){
        if (!todoRepository.existsById(todoId)){
            throw new NullPointerException("todo가 없습니다.");
        }

        todoRepository.deleteById(todoId);
    }


}
