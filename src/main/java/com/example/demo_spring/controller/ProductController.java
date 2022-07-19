package com.example.demo_spring.controller;

import com.example.demo_spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo_spring.repository.ProductRepository;

import java.util.Optional;

@Controller
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Product product){
        return new ResponseEntity(productRepository.save(product), HttpStatus.OK);
    }
    @GetMapping("/search-by-name")
    public ResponseEntity findAllByName(String name){
        return new ResponseEntity(productRepository.findAllByNameContains(name), HttpStatus.OK);
    }
    @GetMapping("/search-by-id/{id}")
    public ResponseEntity findAllById(@PathVariable Long id){
        return new ResponseEntity(productRepository.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Product product){
        Optional<Product> oldProduct = productRepository.findById(id);
        if(!oldProduct.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        product.setId(id);
        productRepository.save(product);
        return new ResponseEntity(HttpStatus.OK);
    }
}
