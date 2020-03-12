package com.enosh.books.controller;

import com.enosh.books.dao.AuthorDao;
import com.enosh.books.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class AuthorController {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Author author) {
        Author afterSave = authorDao.save(author);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(afterSave);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Optional<Author> byId = authorDao.byId(id);
        return byId.isPresent() ?
                ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(byId.get()) :
                ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .contentType(MediaType.TEXT_PLAIN)
                        .body("No author by the id: " + id);
    }

}
