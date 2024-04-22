package com.Quiz_Microservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz_Microservice.model.Question;
import com.Quiz_Microservice.model.Response;
import com.Quiz_Microservice.service.QuizService;

@RestController
@RequestMapping("/api/Quiz")
@CrossOrigin(origins="http://localhost:3000")
public class QuizController {

	@Autowired(required=true)
	private QuizService QuizService;
	
	@Autowired
	Environment environment;


	@GetMapping("{language}/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String language ,@PathVariable String category){
		System.out.println(environment.getProperty("local.server.port"));
		return QuizService.getQuestionsByLanguageAndCategory(language,category);
	}



	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
	{
		return QuizService.getScore(responses);
	}
}









