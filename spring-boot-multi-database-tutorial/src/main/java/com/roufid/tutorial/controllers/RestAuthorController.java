package com.roufid.tutorial.controllers;

import com.roufid.tutorial.dao.mysql.AuthorRepository;
import com.roufid.tutorial.entity.mysql.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by : Ron Rith
 * Create Date: 12/20/2017.
 */
@RestController
public class RestAuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "/rest/authors")
    public List<Author> getAllAuthors(){
        List<Author> authors = (List<Author>) authorRepository.findAll();
        if (authors == null || authors.size() < 5) {
            for (int i = 0; i < 5; i++) {
                Author author = new Author();
                author.setId(Long.valueOf(i + ""));
                author.setFirstname("FirstName" + i);
                author.setLastname("LastName" + i);
                authorRepository.save(author);
            }
        }
        return authors;
    }
}
