package com.example.ToDoList;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Temp {
    @GetMapping("/sbb")
    @ResponseBody
    public String index() {
        return "index";
    }
}
