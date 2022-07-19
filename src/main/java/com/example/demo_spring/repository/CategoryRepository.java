package com.example.demo_spring.repository;

import com.example.demo_spring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByNameContains(String name);
}
