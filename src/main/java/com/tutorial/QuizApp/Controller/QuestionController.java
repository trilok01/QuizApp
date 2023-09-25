package com.tutorial.QuizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.QuizApp.Model.Question;
import com.tutorial.QuizApp.Service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionService questionService;

	@GetMapping("allQuestions")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public List<Question> getQuestionByCategory(@PathVariable String category) {
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("add")
	public Question addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
}
