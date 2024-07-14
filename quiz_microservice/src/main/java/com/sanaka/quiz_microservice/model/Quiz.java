package com.sanaka.quiz_microservice.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@Component
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@ManyToMany
	private List<Integer> questionIDs;

	public List<Integer> getQuestionIDs() {
		return questionIDs;
	}

	public void setQuestionIDs(List<Integer> questionIDs) {
		this.questionIDs = questionIDs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}	
	
}