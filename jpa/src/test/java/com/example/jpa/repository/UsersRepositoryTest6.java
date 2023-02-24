package com.example.jpa.repository;

import com.example.jpa.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class UsersRepositoryTest6 {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {

        Page<Users> usersPage = userRepository.findAll(PageRequest.of(1,2));
        System.out.println("page : "+ usersPage);
        System.out.println("totalElements : " + usersPage.getTotalElements());
        System.out.println("totalPages : " + usersPage.getTotalPages());
        System.out.println("numberOfElements : " + usersPage.getNumberOfElements());
        System.out.println("sort : "+ usersPage.getSort());
        System.out.println("size : "+ usersPage.getSize());
        usersPage.getContent().forEach(System.out::println);
    }
}