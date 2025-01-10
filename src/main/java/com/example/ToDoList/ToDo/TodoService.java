package com.example.ToDoList.ToDo;


import com.example.ToDoList.ToDo.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository toDoRepository;

    public void CreateTodo(String title){
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCreateDate(LocalDateTime.now());
        todo.setComplete(false);
        this.toDoRepository.save(todo);
    }

    public Todo createTodo(Todo todo){
        return this.toDoRepository.save(todo);
    }

    public Todo getTodo(int id){
        Optional<Todo> ot = this.toDoRepository.findById(id);
        if(ot.isPresent()){
            return ot.get();
        }
        else {
            throw new IllegalArgumentException("해당 id의 todo가 없습니다.");
        }
    }

    public List<Todo> getList(){
        List<Todo> todos = this.toDoRepository.findAll().stream()
                .sorted(Comparator.comparing(Todo::getComplete)
                        .thenComparing(Todo::getId))
                .collect(Collectors.toList());



        return todos.stream().sorted(Comparator
                .comparing(Todo::getComplete)
                .thenComparing(Todo::getCreateDate,Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public Todo modifyTodo(Integer id, String title, String content, boolean complete){
        Optional<Todo> ot = this.toDoRepository.findById(id);
        if(ot.isPresent()){
            Todo after =ot.get();
            after.setTitle(title);
            after.setComplete(complete);
            this.toDoRepository.save(after);
            return after;
        }else {
            throw new IllegalArgumentException("해당 id의 todo가 없습니다.");
        }
    }



    public void deleteTodo(int id){
        Optional<Todo> ot = this.toDoRepository.findById(id);
        if(ot.isPresent()){
            this.toDoRepository.delete(ot.get());

        }else{
            throw new IllegalArgumentException("해당 id의 todo가 없습니다.");
        }

    }


}
