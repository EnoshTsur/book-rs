package com.enosh.books.repository;

import com.enosh.books.entities.Author;
import com.enosh.books.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
