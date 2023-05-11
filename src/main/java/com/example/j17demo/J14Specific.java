package com.example.j17demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class J14Specific {

//    @PostConstruct
    public void start() {
        System.out.println("J14 start....");
        instanceofFunc();
        System.out.println(".............");
        recordFunc();
        System.out.println(".............");
        textBlockFunc();
    }

    public void instanceofFunc() {
        Object obj = new ArrayList<>();
        if (obj instanceof ArrayList list) {
            list.add("www.baidu0.com");
        }
        System.out.println(obj);
    }

    public void recordFunc() {
        Dog dog1 = new Dog("牧羊犬", 1);
        Dog dog2 = new Dog("田园犬", 2);
        Dog dog3 = new Dog("哈士奇", 3);
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(dog3);
    }

    public record Dog(String name, Integer age) {
    }

    public void textBlockFunc() {
        String content = """
                {
                    "upperSummary": null,\
                    "sensitiveTypeList": null,
                    "gmtModified": "2011-08-05\s10:50:09",
                }
                 """;
        System.out.println(content);
    }
}
