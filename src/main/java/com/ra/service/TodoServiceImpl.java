package com.ra.service;

import com.ra.entity.TodoList;
import com.ra.repsitory.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements  TodoService {
    @Autowired
    TodoRepository todoRepository;
    @Override
    public List<TodoList> findAll() {
        return (List<TodoList>) todoRepository.findAll();
    }

    @Override
    public TodoList findById(Integer id) {
        Optional<TodoList> optionalTodoList = todoRepository.findById(id);
        return optionalTodoList.orElse(null);
    }

    @Override
    public TodoList save(TodoList todoList) {
        return todoRepository.save(todoList);
    }

    @Override
    public void delete(Integer id) {
        todoRepository.deleteById(id);

    }
}
