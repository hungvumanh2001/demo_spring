package com.example.demo_spring.controller;

import com.example.demo_spring.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo_spring.repository.CategoryRepository;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity(categoryRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Category category){
        return new ResponseEntity(categoryRepository.save(category), HttpStatus.OK);
    }
    @GetMapping("/search-by-name")
    public ResponseEntity findAllByName(String name){
        return new ResponseEntity(categoryRepository.findAllByNameContains(name), HttpStatus.OK);
    }
    @GetMapping("/search-by-id")
    public ResponseEntity findAllById(Long id){
        return new ResponseEntity(categoryRepository.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        categoryRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Category category){
        Optional<Category> oldProduct = categoryRepository.findById(id);
        if(!oldProduct.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        category.setId(id);
        categoryRepository.save(category);
        return new ResponseEntity(HttpStatus.OK);
    }
}
