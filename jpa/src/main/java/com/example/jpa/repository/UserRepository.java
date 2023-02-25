package com.example.jpa.repository;


import com.example.jpa.domain.Users;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByName(String name);

    Users findByEmail(String email);

    Users getByEmail(String email);
    Users readByEmail(String email);
    Users queryByEmail(String email);
    Users searchByEmail(String email);
    Users streamByEmail(String email);

    Users findUsersByEmail(String email);

    List<Users> findFirst1ByName(String name);
    List<Users> findTop1ByName(String name);

    List<Users> findByEmailAndName(String email, String name);

    List<Users> findByEmailOrName(String email, String name);

    List<Users> findByCreatedAtAfter(LocalDateTime yesterday);

    List<Users> findByIdAfter(Long id);

    List<Users> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<Users> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<Users> findByIdIsNotNull();

    List<Users> findByAddressIsNotEmpty(); // name is not null and name != '' x

    List<Users> findByNameIn(List<String> names);

    List<Users> findByNameStartingWith(String name);
    List<Users> findByNameEndingWith(String name);
    List<Users> findByNameContains(String name);

//    List<Users> findByNameLike(String name);
    List<Users> findTop1ByNameOrderByIdDesc(String name);        //정순 역순 키워드 desc(정순), asc(역순)

    List<Users> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<Users> findFirstByName(String name, Sort sort);

    Page<Users> findByName(String name, Pageable pageable);

}
