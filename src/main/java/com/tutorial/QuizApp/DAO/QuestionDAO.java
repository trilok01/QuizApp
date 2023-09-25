package com.tutorial.QuizApp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.QuizApp.Model.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{
	List<Question> findAllByCategory(String category);
}
