package com.sample.QuizApp.dao;

import com.sample.QuizApp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {

    List<Questions> findByCategory(String category);

    @Query(value = "SELECT * FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :nQue", nativeQuery = true)
    List<Questions> findRandomQuestionByCategory(String category, int nQue);
}
