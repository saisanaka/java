package com.sanaka.question_microservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sanaka.question_microservice.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);

	@Query(value = "SELECT * from Question q where q.category=:category ORDER BY RANDOM() LIMIT :num" , nativeQuery = true)
	List<Question> createQuiz(String category , int num);


}
