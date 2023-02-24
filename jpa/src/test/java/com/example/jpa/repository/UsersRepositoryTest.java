package com.example.jpa.repository;

import com.example.jpa.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UsersRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        Users users1 = new Users("jack","jack@gamil.com");
        Users users2 = new Users("steve", "steve@gmail.com");
        userRepository.saveAll(Lists.newArrayList(users1,users2));
        List<Users> usersList = userRepository.findAll();
        usersList.forEach(System.out::println);
    }
}