package com.example.middleware.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/time")
public class BasicController {

    @GetMapping("")
    public LocalDate currentDate() {
        return LocalDate.now();
    }

}
