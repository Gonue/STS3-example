package com.example.jpa.repository;

import com.example.jpa.domain.Gender;
import com.example.jpa.domain.Users;
import org.apache.catalina.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UsersRepositoryTest8 {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;
    @Test
    void crud() {
        userRepository.save(new Users("jk","jk@gmail.com"));

        Users users = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        users.setEmail("jq-update@gmail.com");
        userRepository.save(users);
    }

    @Test
    void select(){
//        System.out.println(userRepository.findByName("kk"));
//        System.out.println("findByEmail : " + userRepository.findByEmail("kk@gmail.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("kk@gmail.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("kk@gmail.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("kk@gmail.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("kk@gmail.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("kk@gmail.com"));
//        System.out.println("findUsersByEmail : " + userRepository.findUsersByEmail("kk@gmail.com"));
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("kk"));
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("kk"));
//        System.out.println("findByEmailAndName :" + userRepository.findByEmailAndName("kk@gmail.com", "kk"));
//        System.out.println("findByEmailAndName :" + userRepository.findByEmailAndName("kk@gmail.com", "gg"));
//        System.out.println("findByEmailOrName :" + userRepository.findByEmailOrName("kk@gmail.com", "kk"));
//        System.out.println("findByEmailOrName :" + userRepository.findByEmailOrName("kk@gmail.com", "qq"));
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)).forEach(System.out::println);
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
//        System.out.println("findByCreateAtGreaterThan " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreateAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        userRepository.findByIdIsNotNull().forEach(System.out::println);
//        System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());
//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("kk", "qq")));
        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("k"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("k"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("k"));
//        System.out.println("findByNameLike : " + userRepository.findByNameLike("%k"));
    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("kk"));
        System.out.println("findTop1ByNameOrderByIdDesc : " + userRepository.findTop1ByNameOrderByIdDesc("kk"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("kk"));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("kk", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findByNameWithPaging : " + userRepository.findByName("kk", PageRequest.of(1,1,Sort.by(Sort.Order.desc("id")))).getContent());
    }

    @Test
    void insertAndUpdateTest(){
        Users users = new Users();
        users.setName("kk");
        users.setEmail("kk@gmail.com");
        userRepository.save(users);

        Users users2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        users2.setName("kkk");
        userRepository.save(users2);
    }

    @Test
    void enumTest(){
        Users users = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        users.setGender(Gender.MALE);

        userRepository.save(users);
        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    @Test
    void prePersistTest(){
        Users users = new Users();
        users.setName("kk");
        users.setEmail("kk2@gmail.com");
        userRepository.save(users);
        System.out.println(userRepository.findByEmail("kk@gmail.com"));
    }

    @Test
    void preUpdateTest(){
        Users users = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        System.out.println("as-is : " + users);

        users.setName("kk22");
        userRepository.save(users);
        System.out.println("to-be : "+ userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest(){
        Users users = new Users();
        users.setEmail("kk-new@gmail.com");
        users.setName("kk-new");

        userRepository.save(users);
        users.setName("kk-new-new");
        userRepository.save(users);

        userHistoryRepository.findAll().forEach(System.out::println);
    }
}