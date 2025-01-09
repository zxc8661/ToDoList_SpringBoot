package com.example.ToDoList;

import com.example.ToDoList.ToDo.Todo;
import com.example.ToDoList.ToDo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ToDoListApplication implements CommandLineRunner {

	private final TodoRepository todoRepository;
	public static void main(String[] args) {

		SpringApplication.run(ToDoListApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception{
		List Todos = List.of(
				new Todo(null, "title1", "description1", LocalDateTime.now(), null, false),
				new Todo(null, "title2", "description2", LocalDateTime.now(), null, false),
				new Todo(null, "title3", "description3", LocalDateTime.now(), null, false));


		todoRepository.saveAll(Todos);
	}


}
