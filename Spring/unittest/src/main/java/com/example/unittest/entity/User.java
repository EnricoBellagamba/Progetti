package com.example.unittest.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String surname;

    @Column(nullable = true)
    private Integer age;

}
