package com.ra.controller;

import com.ra.entity.TodoList;
import com.ra.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoService todoService;
    @GetMapping
    public ResponseEntity<List<TodoList>> getAllTodo(){
        List<TodoList> list = todoService.findAll();
        return  new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TodoList> createTodo(@RequestBody TodoList todoList){
       TodoList todoListNew = todoService.save(todoList);
        if(todoListNew == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(todoListNew,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<TodoList> findById (@PathVariable("id") Integer id){
        TodoList todoList = todoService.findById(id);
        if(todoList == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(todoList,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<TodoList> editTodo(@PathVariable("id") Integer id, @RequestBody TodoList todoList){
        if (todoService.findById(id)== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        TodoList newTodo = todoService.save(todoList);
        return new ResponseEntity<>(newTodo,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TodoList> delete (@PathVariable("id") Integer id){
        if(todoService.findById(id)!= null){
            todoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
