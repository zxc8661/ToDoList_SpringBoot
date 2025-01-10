package com.example.ToDoList.User.controller;


import com.example.ToDoList.User.entity.SiteUser;
import com.example.ToDoList.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app")
public class UserController {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SiteUser user){
        this.userService.createUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody SiteUser user){
        SiteUser existUser = userService.findByUsername(user.getUsername());
        if(existUser != null && passwordEncoder.matches(user.getPassword(), existUser.getPassword()))
            return ResponseEntity.ok("login O");
        else
            return ResponseEntity.status(401).body("login X");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok("Logout O");
    }

}
