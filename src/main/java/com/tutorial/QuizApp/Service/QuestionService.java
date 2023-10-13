package com.tutorial.QuizApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tutorial.QuizApp.DAO.QuestionDAO;
import com.tutorial.QuizApp.DTO.ResponseDTO;
import com.tutorial.QuizApp.Model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDAO questionDAO;
	
	public List<Question> getAllQuestions() {
		return questionDAO.findAll();
	}

	public List<Question> getQuestionByCategory(String category) {
		return questionDAO.findAllByCategory(category);
	}

	public Question addQuestion(Question question) {
		return questionDAO.save(question);
	}

	public ResponseDTO deleteQuestion(Integer questionId) {
		ResponseDTO responseDTO = new ResponseDTO();
		
		try {
			questionDAO.deleteById(questionId);
			
			responseDTO.setHttpStatusCode(HttpStatus.OK);
			responseDTO.setMessage("Deleted Successfully");
		} catch(Exception e) {
			responseDTO.setHttpStatusCode(HttpStatus.NOT_FOUND);
			responseDTO.setMessage("Question with given id not found");
		}
		
		return responseDTO;
	}
}
