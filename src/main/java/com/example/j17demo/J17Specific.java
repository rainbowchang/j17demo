package com.example.j17demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.Console;

@Component
public class J17Specific {

    @PostConstruct
    public void start() {
        System.out.println("J17......");
        consoleFunc();
    }

    //Console 不能在idea下执行，只能编译成jar 或 class 在命令行执行
    public void consoleFunc() {
//        Console console = System.console();
//        console.printf("aaa %s %s", "bbb", "cccc");
    }
}
