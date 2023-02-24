package com.example.jpa.repository;

import com.example.jpa.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersRepositoryTest3 {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        boolean exists = userRepository.existsById(1L);
        System.out.println(exists);
    }
}