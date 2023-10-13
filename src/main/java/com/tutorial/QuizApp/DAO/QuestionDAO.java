package com.tutorial.QuizApp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tutorial.QuizApp.Model.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{
	List<Question> findAllByCategory(String category);

	@Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	List<Question> findQuestionByCategory(String category, int numQ);
}
