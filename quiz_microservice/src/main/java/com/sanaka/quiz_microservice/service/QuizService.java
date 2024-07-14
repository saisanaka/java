package com.sanaka.quiz_microservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanaka.quiz_microservice.model.QuestionWrapper;
import com.sanaka.quiz_microservice.model.Quiz;
import com.sanaka.quiz_microservice.model.Response;

@Service
public class QuizService {

//		private final QuizRepo quizrepo;
	
		@Autowired
		private Quiz quiz;
		
//		@Autowired
//		public QuizService(QuestionRepo repo , QuizRepo quizrepo , Quiz quiz) {
//			this.repo = repo;
//			this.quizrepo = quizrepo;
//			this.quiz = quiz;
//		}

		public void createQuiz(String category, int num, String title) {
			
			List<Integer> questions = new ArrayList<Integer>();
			
		}

		public List<QuestionWrapper> getQuiz(int id) {
			
//			Optional<Quiz> quiz= quizrepo.findById(id);
//			List<Question> questions = quiz.get().getQuestions();
			List<QuestionWrapper> questionsToUser = new ArrayList<QuestionWrapper>();
//			for(Question q : questions) {
//				QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
//				questionsToUser.add(qw);
//			}
			return questionsToUser;
		}
		
		public Integer submitQuiz(Integer id, List<Response> response) {
		
//			Quiz quiz = quizrepo.findById(id).get();
//			List<Question> questions = quiz.getQuestions();
//			System.out.println("************\n\n\n\n\n\n");
//			System.out.println(questions);
//			System.out.println("************\n\n\n\n\n\n");
//			int i=0;
			int result = 0;
//			for(Response resp : response) {
//				if(resp.getResponse().equals(questions.get(i).getRightAnswer())){
//					result++;
//				}
//				i++;
//			}
			return result;
		}
		
}
