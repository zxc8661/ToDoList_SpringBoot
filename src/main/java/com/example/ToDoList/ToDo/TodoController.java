package com.example.ToDoList.ToDo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/todos")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity< List<Todo>> getAllTodos(){
        return ResponseEntity.ok(
                this.todoService.getList()
        );
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody Todo todo){
        if(todo.getTitle().isEmpty() || todo.getTitle()==null){
            return ResponseEntity.badRequest().body("title empty");
        }
        todo.setCreateDate(LocalDateTime.now());
        todo.setComplete(false);
        return ResponseEntity.ok(
                this.todoService.createTodo(todo)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Integer id){
        this.todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyTodo(@PathVariable("id") Integer id,
                                        @RequestBody Todo newtodo) {
        try{
            Todo todo = this.todoService.getTodo(id);
            if(!newtodo.getTitle().isEmpty()){
                todo.setTitle(newtodo.getTitle());
            }
            if(!newtodo.getDescription().isEmpty()){
                todo.setDescription(newtodo.getDescription());
            }
            return ResponseEntity.ok(
                    this.todoService.createTodo(todo)
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("뭔가 잘못됨,해당 id가 없을 지도?");
        }
    }

    @PutMapping("/done/{id}")
    public ResponseEntity<?> modifyComplete(@PathVariable("id") Integer id){
        Todo todo = this.todoService.getTodo(id);
        todo.setComplete(!todo.getComplete());
        return ResponseEntity.ok(
                this.todoService.createTodo(todo)
        );
    }
}
