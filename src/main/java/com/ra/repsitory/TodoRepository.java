package com.ra.repsitory;

import com.ra.entity.TodoList;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoList, Integer> {
}
