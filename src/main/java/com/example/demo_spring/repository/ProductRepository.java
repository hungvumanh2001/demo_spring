package com.example.demo_spring.repository;

import com.example.demo_spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameContains(String name);
    List<Product> findAllById(Long id);
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByCategory_Name(String name);
}
