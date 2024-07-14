package com.sanaka.quiz_microservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanaka.quiz_microservice.model.QuestionWrapper;
import com.sanaka.quiz_microservice.model.QuizDto;
import com.sanaka.quiz_microservice.model.Response;
import com.sanaka.quiz_microservice.service.QuizService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("quiz")
public class QuizController {

	private final QuizService service;
	
	@Autowired
	public QuizController(QuizService service) {
		this.service = service;
	}
	
	@GetMapping("get/{id}")
	private ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
		List<QuestionWrapper> questions = service.getQuiz(id);
		return ResponseEntity.status(200).body(questions);
	}
	
	@PostMapping("create")
	private ResponseEntity<String> createQuiz(@RequestBody QuizDto dto) {
		
		service.createQuiz(dto.getCategoryName() , dto.getNumQuestions() , dto.getTitle());
		
		return ResponseEntity.status(201).body("Quiz created Successfully");
		
	}
	
	@PostMapping("submit/{id}")
	private ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> response){
		Integer result = service.submitQuiz(id ,response);
		return ResponseEntity.status(201).body(result);
	}
	
}
