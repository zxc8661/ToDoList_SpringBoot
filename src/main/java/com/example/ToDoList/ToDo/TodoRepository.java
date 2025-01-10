package com.example.ToDoList.ToDo;

import com.example.ToDoList.ToDo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
