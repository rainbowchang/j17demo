package com.example.j17demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class J13Specific {
//    @PostConstruct
    public void start() {
        yieldFunc("3");
    }

    public void yieldFunc(String x) {
        String[] args = new String[]{"aa", "bbb", "cccc", "ddddd"};
        int i = switch (x) {
            case "1":
                yield 1;
            case "2":
                yield 2;
            default: {
                int len = args[1].length();
                yield len;
            }
        };
        System.out.println("............... i = " + i);
    }

}
