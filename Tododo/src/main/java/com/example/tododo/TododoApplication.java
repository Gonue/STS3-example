package com.example.tododo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TododoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TododoApplication.class, args);
    }

}
