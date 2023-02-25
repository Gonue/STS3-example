package com.example.jpa.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class UsersTest {
    @Test
    void test(){
        Users users = new Users();
        users.setEmail("kk@gmail.com");
        users.setName("kk");
        Users users1 = new Users(null,"kk","kk@gmail.com", LocalDateTime.now(),LocalDateTime.now(),null);
        Users users2 = new Users("kk", "kk@gmail.com");
        Users users3 = Users.builder()
                .name("kj")
                .email("kk@gmail.com")
                .build();
        System.out.println(">>> "+ users);
        System.out.println(">>> "+ users1);
        System.out.println(">>> "+ users2);
        System.out.println(">>> "+ users3);


    }
}