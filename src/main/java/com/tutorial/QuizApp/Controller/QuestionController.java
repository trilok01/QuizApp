package com.tutorial.QuizApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.QuizApp.DTO.ResponseDTO;
import com.tutorial.QuizApp.Model.Question;
import com.tutorial.QuizApp.Service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionService questionService;

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
		try {
			return new ResponseEntity<>(questionService.getQuestionByCategory(category), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		try {
			questionService.addQuestion(question);
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("delete/{questionId}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer questionId) {
		ResponseDTO responseDTO = questionService.deleteQuestion(questionId);
		return new ResponseEntity<>(responseDTO.getMessage(), responseDTO.getHttpStatusCode());
	}
}
