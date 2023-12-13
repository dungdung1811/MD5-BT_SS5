package com.ra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Integer id;
    private String todoName;
    private Boolean todoStatus;

    public TodoList() {
    }

    public TodoList(Integer id, String todoName, Boolean todoStatus) {
        this.id = id;
        this.todoName = todoName;
        this.todoStatus = todoStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public Boolean getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(Boolean todoStatus) {
        this.todoStatus = todoStatus;
    }
}
