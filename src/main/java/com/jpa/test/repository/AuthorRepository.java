package com.jpa.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}



