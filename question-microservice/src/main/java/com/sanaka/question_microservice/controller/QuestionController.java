package com.sanaka.question_microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanaka.question_microservice.model.Question;
import com.sanaka.question_microservice.model.QuestionWrapper;
import com.sanaka.question_microservice.model.Response;
import com.sanaka.question_microservice.service.QuestionService;

@RestController
@RequestMapping("Question")
public class QuestionController {
	
	private final QuestionService service;
	
	@Autowired
	public QuestionController(QuestionService service) {
		this.service = service;
	}
	
//	returning all the questions from Question DB	
	@GetMapping("allQuestions")
	private ResponseEntity<List<Question>> getAllQuestions() {
		return ResponseEntity.ok().body(service.getAllQuestions());
	}
	
//	returning all the questions from Question DB which matches the category as specified 
	@GetMapping("category")
	private ResponseEntity<List<Question>> generateQuestionsByCategory(@RequestParam String category){
		return ResponseEntity.ok().body(service.getByCategory(category));
	}
	
//	returning the question ID's for Quiz
	@GetMapping("generateQuestions")
	private ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam String category , @RequestParam Integer numOfQuestions){
		List<Integer> quiz = service.generateRandomQuestionIds(category , numOfQuestions);
		return ResponseEntity.status(200).body(quiz);
	}
	
//	returning the questions for Quiz from the question ID 
	@GetMapping("getQuestions")
	private ResponseEntity<List<QuestionWrapper>> getQuestionById(@RequestBody List<Integer> questionIDs){
		return new ResponseEntity<>(service.getQuestionsforIDs(questionIDs) , HttpStatus.OK);
	}
	
	
//	creating a question in the database
	@PostMapping("create")
	private ResponseEntity<String> addNewQuestionToDataBase(@RequestBody Question question){
		boolean created = service.createQuestion(question);
		if(created) return ResponseEntity.status(201).body("New Question Created Successfully");
		return ResponseEntity.status(500).body("Something went wrong");
	}
	
//	calculating the result for the submitted responses
	@PostMapping("submit")
	private ResponseEntity<Integer> calculateResult(@RequestBody List<Response> responses) {
		return new ResponseEntity<>(service.calculateScore(responses) , HttpStatus.OK);
	}
	
}
