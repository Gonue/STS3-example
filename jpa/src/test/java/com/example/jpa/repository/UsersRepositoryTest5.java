package com.example.jpa.repository;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersRepositoryTest5 {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L)));
        userRepository.findAll().forEach(System.out::println);
    }
}