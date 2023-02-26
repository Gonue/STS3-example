package com.example.jpa.repository;

import com.example.jpa.domain.Gender;
import com.example.jpa.domain.UserHistory;
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
    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void userRelationTest() {
        Users users = new Users();
        users.setName("david");
        users.setEmail("david@gmail.com");
        users.setGender(Gender.MALE);
        userRepository.save(users);

        users.setName("daniel");
        userRepository.save(users);

        users.setEmail("daniel@gmail.com");
        userRepository.save(users);

//        userHistoryRepository.findAll().forEach(System.out::println);

//        List<UserHistory> result = userHistoryRepository.findByUserId(
//            userRepository.findByEmail("daniel@fastcampus.com").getId());

        List<UserHistory> result = userRepository.findByEmail("daniel@fastcampus.com").getUserHistories();

        result.forEach(System.out::println);
    }
}