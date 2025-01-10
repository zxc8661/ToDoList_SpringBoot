package com.example.ToDoList;

import com.example.ToDoList.ToDo.entity.Todo;
import com.example.ToDoList.ToDo.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class ToDoListApplicationTests {

	@Autowired
	private TodoRepository toDoRepository;

	@Test
	void createToDo(){
		Todo todo = new Todo();
		todo.setDescription("test");
		todo.setTitle("test");

		todo.setCreateDate(LocalDateTime.now());

		Todo todo2 = new Todo();
		todo2.setDescription("test");
		todo2.setTitle("test");
		todo2.setCreateDate(LocalDateTime.now());

		this.toDoRepository.save(todo);
		this.toDoRepository.save(todo2);
	}

	@Test
	void modifyTodo(){
		Optional<Todo> o1 = this.toDoRepository.findById(1);
		Todo todo1=o1.get();
		todo1.setComplete(true);
		this.toDoRepository.save(todo1);

		Optional<Todo> o2 = this.toDoRepository.findById(2);
		Todo todo2=o2.get();
		todo2.setComplete(true);
		this.toDoRepository.save(todo2);
	}

}
