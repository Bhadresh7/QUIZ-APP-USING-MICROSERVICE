
package com.Quiz_Microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Quiz_Microservice.model.Question;

@Repository
public interface QuizRepository extends JpaRepository<Question, Integer>{

	@Query(value ="SELECT * FROM question q WHERE q.category = :category AND q.language = :language ORDER BY RAND() LIMIT 5", nativeQuery = true)
	List<Question> findByLanguageAndCategory(String language,String category);



}