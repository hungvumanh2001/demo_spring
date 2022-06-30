package com.example.demo_spring.controller;

import com.example.demo_spring.model.Product;
import com.example.demo_spring.repository.ProductRepository;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
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
    @GetMapping("/search-by-id")
    public ResponseEntity findAllById(Long id){
        return new ResponseEntity(productRepository.findAllById(id), HttpStatus.OK);
    }
    @GetMapping("/order-by-price")
    public ResponseEntity findAllByOrderByPriceAsc(){
        return new ResponseEntity(productRepository.findAllByOrderByPriceAsc(), HttpStatus.OK);
    }
    @GetMapping("/search-by-category")
    public ResponseEntity findAllByCategory(String name){
        return new ResponseEntity(productRepository.findAllByCategory_Name(name), HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity delete(Long id){
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
