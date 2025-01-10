package com.example.ToDoList.User.repository;

import com.example.ToDoList.User.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser,Long> {
    SiteUser findByUsername(String username);
}
