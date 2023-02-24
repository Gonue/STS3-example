package com.example.jpa.repository;

import com.example.jpa.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersRepositoryTest2 {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        userRepository.saveAndFlush(new Users("new kk","kk@gmail.com"));
        userRepository.findAll().forEach(System.out::println);
    }
}