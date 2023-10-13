package com.tutorial.QuizApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.QuizApp.DAO.QuestionDAO;
import com.tutorial.QuizApp.DAO.QuizDAO;
import com.tutorial.QuizApp.Model.Question;
import com.tutorial.QuizApp.Model.QuestionWrapper;
import com.tutorial.QuizApp.Model.Quiz;

@Service
public class QuizService {
	@Autowired
	QuizDAO quizDAO;
	
	@Autowired
	QuestionDAO questionDAO;
	
	public Quiz createQuiz(String category, int numQ, String title) {
		List<Question> questions = questionDAO.findQuestionByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		
		return quizDAO.save(quiz);
	}

	public List<QuestionWrapper> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDAO.findById(id);
		List<Question> questions = quiz.get().getQuestions();
		
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		
		for(Question question : questions) {
			QuestionWrapper tempQustion = new QuestionWrapper(question.getId(), question.getQuestionTitle(), 
					question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
			
			questionsForUser.add(tempQustion);
		}
		return questionsForUser;
	}
}
