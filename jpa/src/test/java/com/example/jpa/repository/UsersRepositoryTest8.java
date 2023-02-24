package com.example.jpa.repository;

import com.example.jpa.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UsersRepositoryTest8 {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        userRepository.save(new Users("jk","jk@gmail.com"));

        Users users = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        users.setEmail("jq-update@gmail.com");
        userRepository.save(users);
    }
}