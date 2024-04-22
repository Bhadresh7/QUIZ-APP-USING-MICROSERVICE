
package com.Quiz_Microservice.service;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Quiz_Microservice.model.Question; 
import com.Quiz_Microservice.model.Response; 
import com.Quiz_Microservice.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired 
	private QuizRepository QuizRepo;

	public ResponseEntity<List<Question>>getQuestionsByLanguageAndCategory(String language,String category)
	{ 
		try 
		{
			return new ResponseEntity<>(QuizRepo.findByLanguageAndCategory(language,category),HttpStatus.OK);
		}
		catch (Exception e)
		{ 
			e.printStackTrace(); 
		} return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		int right = 0;
		for(Response response : responses)
		{
			Question question =QuizRepo.findById(response.getId()).get();
			if(response.getResponse().equals(question.getRightanswer())) 
				right++; 
		}
		return new ResponseEntity<>(right, HttpStatus.OK); 
	}
}
