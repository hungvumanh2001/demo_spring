package com.example.demo_spring.repository;

import com.example.demo_spring.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
