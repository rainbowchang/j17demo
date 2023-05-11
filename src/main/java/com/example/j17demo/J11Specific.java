package com.example.j17demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class J11Specific {

//    @PostConstruct
    public void start() {
        System.out.println("J11 start....");
        stringFunc();
        System.out.println("..........");
        predicateFunc();
        System.out.println("..........");
        try {
            httpClientFunc();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("..........");
        streamFunc();
        System.out.println("..........");
        optionalFunc();
    }

    public void stringFunc() {
        String blankStr = "    ";
        // true
        boolean trueVal = blankStr.isBlank();
        System.out.println(trueVal);

        String newStr = "Hello Java 11 \n felord.cn \r 2021-09-28";
        Stream<String> lines = newStr.lines();
        lines.forEach(System.out::println);

        String str = " HELLO\u3000";
        // str = 6
        System.out.println(str + " str = " + str.length());
        // trim = 6
        System.out.println(str + " trim = " + str.trim().length());
        // strip = 5
        System.out.println(str + " strip = " + str.strip().length());


        String str02 = "HELLO";
        // 空字符
        String empty = str02.repeat(0);
        // HELLO
        String repeatOne = str02.repeat(1);
        // HELLOHELLO
        String repeatTwo = str02.repeat(2);

        System.out.println("empty = " + empty);
        System.out.println("repeatOne = " + repeatOne);
        System.out.println("repeatTwo = " + repeatTwo);

        List<String> sampleList = Arrays.asList("张三", "java 11");
        // array = {"张三", "java 11"};
        String[] array = sampleList.toArray(String[]::new);
        System.out.println(array[1]);
    }


    public void predicateFunc() {
        List<String> sampleList = Arrays.asList("张三", "java 11", "jack");
        // [jack]
        List<String> result = sampleList.stream()
                // 过滤以j开头的字符串
                .filter(s -> s.startsWith("j"))
                // 同时不包含11的字符串
                .filter(Predicate.not(s -> s.contains("11")))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public void fileFunc() throws IOException {
        String dir = "C://yourDir/hello.txt";
        // 写入文件
        Path path = Files.writeString(Path.of(dir), "hello java 11");
        // 读取文件
        String fileContent = Files.readString(path);
        // hello java 11
        System.err.println(fileContent);
    }

    public void httpClientFunc() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://baidu.com"))
                .GET()
                .build();
        var client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public void httpClientFunc02() {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://baidu.com"))
                .build();
        var client = HttpClient.newHttpClient();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
    }

    public void streamFunc() {
        List<Integer> a = Stream.of(1, 2, 3, 2, 1)
                .dropWhile(n -> n < 3)
                .collect(Collectors.toList());  // [3, 2, 1]

        List<Integer> b = Stream.of(1, 2, 3, 2, 1)
                .takeWhile(n -> n < 3)
                .collect(Collectors.toList());  // [1, 2]
        System.out.println(a);
        System.out.println(b);
    }

    public void optionalFunc() {
        var s = Optional.of("foo").orElseThrow();     // foo
        var i = Optional.of("foo").stream().count();  // 1
        var t = Optional.ofNullable(null)
                .or(() -> Optional.of("fallback"))
                .get();

        System.out.println(s);
        System.out.println(i);
        System.out.println(t);
    }
}
