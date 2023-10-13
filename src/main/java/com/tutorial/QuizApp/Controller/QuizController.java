package com.tutorial.QuizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.QuizApp.Model.QuestionWrapper;
import com.tutorial.QuizApp.Model.Quiz;
import com.tutorial.QuizApp.Service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizService;

	@PostMapping("create")
	public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam int numQues, @RequestParam String title) {
		Quiz quiz = quizService.createQuiz(category, numQues, title);
		
		return new ResponseEntity<>(quiz, HttpStatus.CREATED);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
		List<QuestionWrapper> questions = quizService.getQuizQuestions(id);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}
}
