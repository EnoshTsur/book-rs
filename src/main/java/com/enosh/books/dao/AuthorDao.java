package com.enosh.books.dao;

import com.enosh.books.entities.Author;
import com.enosh.books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class AuthorDao {

    private final AuthorRepository authorRepository;


    @Autowired
    public AuthorDao(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public Optional<Author> byId(Long id) {
        return authorRepository.findById(id);
    }

    public Author save(Author author){
        return authorRepository.save(author);
    }
}
