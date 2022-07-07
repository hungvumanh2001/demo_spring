package com.example.demo_spring.controller;

import com.example.demo_spring.model.Answer;
import com.example.demo_spring.model.Question;
import com.example.demo_spring.repository.AnswerRepository;
import com.example.demo_spring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    AnswerRepository answerRepository;
    @PostMapping
    public ResponseEntity save(@RequestBody Answer answer){
        return new ResponseEntity(answerRepository.save(answer), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity(answerRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findAllById(@PathVariable Long id){
        return new ResponseEntity(answerRepository.findById(id), HttpStatus.OK);
    }
    @GetMapping("/search-by-name")
    public ResponseEntity findAllByName(String key){
        return new ResponseEntity(answerRepository.findAllByNameContains(key), HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Answer answer){
        Optional<Answer> oldProduct = answerRepository.findById(id);
        if(!oldProduct.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        answer.setId(id);
        answerRepository.save(answer);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(Long id){
        answerRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
