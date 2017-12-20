package com.roufid.tutorial.controllers;

import com.roufid.tutorial.dao.postgresql.BookRepository;
import com.roufid.tutorial.entity.postgresql.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by : Ron Rith
 * Create Date: 12/20/2017.
 */
@RestController
public class RestBookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/rest/books")
    public List<Book> getAllBooks(){
        List<Book> books = (List<Book>) bookRepository.findAll();
        if (books == null || books.size() < 5) {
            for(int i=0;i<5;i++){
                Book book = new Book();
                book.setId(Long.valueOf(i+""));
                book.setAuthorId(Long.valueOf(i+""));
                book.setName("Dara"+i);
                bookRepository.save(book);
            }

        }

        return books;
    }
}
