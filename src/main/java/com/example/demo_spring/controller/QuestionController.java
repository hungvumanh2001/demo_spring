package com.example.demo_spring.controller;

import com.example.demo_spring.model.Question;
import com.example.demo_spring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;
    @GetMapping
    public ResponseEntity<Question> findAll(){
        return new ResponseEntity(questionRepository.findAll(), HttpStatus.OK);
    }
}
