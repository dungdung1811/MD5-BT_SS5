package com.ra.service;

import com.ra.entity.TodoList;

import java.util.List;

public interface TodoService {
    List<TodoList> findAll();
    TodoList findById(Integer id);
    TodoList save(TodoList todoList);
    void delete(Integer id);
}
