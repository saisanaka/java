package com.sanaka.question_microservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanaka.question_microservice.model.Question;
import com.sanaka.question_microservice.model.QuestionWrapper;
import com.sanaka.question_microservice.model.Response;
import com.sanaka.question_microservice.repo.QuestionRepo;

@Service
public class QuestionService {
	
	private final QuestionRepo repo;
	
	@Autowired
	public QuestionService(QuestionRepo repo) {
		this.repo = repo;
	}

	public List<Question> getAllQuestions() {
		return repo.findAll();
	}

	public List<Question> getByCategory(String category) {
		return repo.findByCategory(category);
	}

	public boolean createQuestion(Question question) {
		repo.save(question);
		return true;
	}

	public Integer calculateScore(List<Response> responses) {
		// TODO Auto-generated method stub
		
		Integer score = 0;
		List<QuestionWrapper> wrapper = new ArrayList<QuestionWrapper>()
;
//		for(Response response : responses) {
//			Question question = repo.findById(response.getId()).get();
//			wrapper.add(new QuestionWrapper(question.getId(), question.getQuestionTitle() , question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4()));
//		}
		
		for(Response response : responses) {
			Question question = repo.findById(response.getId()).get();
			if(question.getRightAnswer().equals(response.getResponse())) {
				score++;
			}
		}
		
		return score;
	}

	public List<Integer> generateRandomQuestionIds(String category, Integer numOfQuestions) {
		// TODO Auto-generated method stub
		List<Question> questions = repo.createQuiz(category , numOfQuestions);
		List<Integer> list = new ArrayList<>();
		for(Question question : questions) {
			list.add(question.getId());
		}
		return list;
	}

	public List<QuestionWrapper> getQuestionsforIDs(List<Integer> questionIDs) {
		List<QuestionWrapper> wrapper = new ArrayList<QuestionWrapper>();
		for(Integer id : questionIDs) {
			Question question = repo.findById(id).get();
			wrapper.add(new QuestionWrapper(question.getId(), question.getQuestionTitle() , question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4()));
		}
		return wrapper;
	}

}
