package com.tutorial.QuizApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.QuizApp.DAO.QuestionDAO;
import com.tutorial.QuizApp.Model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDAO questionDAO;
	
	public List<Question> getAllQuestions() {
		return questionDAO.getAllQuestions();
	}
}
