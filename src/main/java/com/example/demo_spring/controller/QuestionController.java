package com.example.demo_spring.controller;

import com.example.demo_spring.model.Question;
import com.example.demo_spring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;
    @PostMapping
    public ResponseEntity save(@RequestBody Question question){
        return new ResponseEntity(questionRepository.save(question), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity(questionRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findAllById(@PathVariable Long id){
        return new ResponseEntity(questionRepository.findById(id), HttpStatus.OK);
    }
    @GetMapping("/search-by-name")
    public ResponseEntity findAllByName(String key){
        return new ResponseEntity(questionRepository.findAllByContentContains(key), HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Question question){
        Optional<Question> oldProduct = questionRepository.findById(id);
        if(!oldProduct.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        question.setId(id);
        questionRepository.save(question);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(Long id){
        questionRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
