package com.example.j17demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class J16Specific {

//    @PostConstruct
    public void start() {
        System.out.println(DateTimeFormatter.ofPattern("B").format(LocalTime.now()));
    }
}
