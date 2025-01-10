package com.example.ToDoList.User.service;

import com.example.ToDoList.User.entity.SiteUser;
import com.example.ToDoList.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void createUser(String username, String password){
        SiteUser user = SiteUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .createDate(LocalDateTime.now())
                .build();
        this.userRepository.save(user);
    }

    public SiteUser findByUsername(String username){
        return this.userRepository.findByUsername(username);
    }
}
