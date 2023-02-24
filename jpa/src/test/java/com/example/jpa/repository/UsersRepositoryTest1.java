package com.example.jpa.repository;

import com.example.jpa.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class UsersRepositoryTest1 {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        Users users = userRepository.findById(1L).orElse(null);
        System.out.println(users);
    }
}