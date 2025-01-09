package com.example.ToDoList.ToDo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 500)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;


    private Boolean complete;


}
