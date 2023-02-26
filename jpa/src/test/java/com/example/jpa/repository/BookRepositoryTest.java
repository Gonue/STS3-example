package com.example.jpa.repository;


import com.example.jpa.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("haha");
        book.setAuthor("김아무개");

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }
}
