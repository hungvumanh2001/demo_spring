package com.example.demo_spring.model;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int isTrue;
    @ManyToOne
    private Question question;

}
