package com.example.deploy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MyController {

    Random random = new Random();

    @GetMapping
    public int somma(@RequestParam int min, @RequestParam int max) {

        int random1 = random.nextInt(max - min) + min;
        int random2 = random.nextInt(max - min) + min;

        return random1 + random2;
    }
}

