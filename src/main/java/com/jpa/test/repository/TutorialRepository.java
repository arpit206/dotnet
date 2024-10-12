package com.jpa.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.model.Tutorial;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}



