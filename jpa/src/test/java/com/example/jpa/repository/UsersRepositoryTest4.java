package com.example.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersRepositoryTest4 {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        userRepository.findAll().forEach(System.out::println);
    }
}