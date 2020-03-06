package com.enosh.books.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    @ManyToMany(mappedBy = "books")
    private List<Customer> customers = new ArrayList<>();

    public Book(){}

    public Book(String name, LocalDate publishDate, Author author) {
        this.name = name;
        this.publishDate = publishDate;
        this.author = author;
    }

    public Book(String name, LocalDate publishDate, Author author, List<Customer> customers) {
        this.name = name;
        this.publishDate = publishDate;
        this.author = author;
        this.customers = customers;
    }

    public Book(Long id, String name, LocalDate publishDate, Author author) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
        this.author = author;
    }

    public Book(Long id, String name, LocalDate publishDate, Author author, List<Customer> customers) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
        this.author = author;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
