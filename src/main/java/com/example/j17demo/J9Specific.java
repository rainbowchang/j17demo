package com.example.j17demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

@Component
public class J9Specific {

//    @PostConstruct
    public void func01() {
        System.out.println("J9 start....");
        String text = """
                { "name": "小黑说Java", "age": 18, "address": "北京市西城区" }
                """;
        System.out.println(text);
        withSwitchExpression("PEAR");
        collectionFunc();
        streamFunc();
    }

    private void withSwitchExpression(String fruit) {
        switch (fruit) {
            case "APPLE", "PEAR" -> {
                System.out.println("普通水果");
                System.out.println("xxxxxxxxxxxxx");
            }
            case "MANGO", "AVOCADO" -> System.out.println("进口水果");
            default -> System.out.println("未知水果");
        }
    }

    public void collectionFunc() {
        List<String> list = List.of("a", "b", "c");
        Set<String> set = Set.of("a", "b", "c");
        //Map的两种初始化方式，个人喜欢第二种，语意更加清晰些，也不容易错
        Map<String, Integer> map1 = Map.of("Tom", 12, "Jerry", 21,
                "Lilei", 33, "HanMeimei", 18);
        Map<String, Integer> map2 = Map.ofEntries(
                Map.entry("Tom", 89),
                Map.entry("Jim", 78),
                Map.entry("Tim", 98)
        );
        List<String> listOld = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
        System.out.println(list.getClass().getName());
        System.out.println(listOld.getClass().getName());
    }

    public void streamFunc() {
        Stream<Object> stream1 = Stream.ofNullable(null);
        System.out.println(stream1.count());
    }

//    public void httpApiFunc() {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest req = HttpRequest.newBuilder(URI.create("http://www.baidu.com")).GET().build();
//        HttpResponse<String> response = client.send(req,
//                HttpResponse.BodyHandler.asString(""));
//        System.out.println(response.statusCode());
//        System.out.println(response.version().name());
//        System.out.println(response.body());
//    }
}
