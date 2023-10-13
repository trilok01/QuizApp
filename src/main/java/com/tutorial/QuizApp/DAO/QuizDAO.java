package com.tutorial.QuizApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.QuizApp.Model.Quiz;

public interface QuizDAO extends JpaRepository<Quiz, Integer> {

}
