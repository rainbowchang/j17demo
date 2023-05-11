package com.example.j17demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class J10Specific {
//    @PostConstruct
    public void start() {
        System.out.println("J10 start....");
        varFunc();
    }

    public void varFunc() {
        var list = new ArrayList<String>();
        list.add("hello，world！");
        System.out.println(list);
    }

}
