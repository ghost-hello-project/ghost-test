package com.laolang.jx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RestTemplateStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestTemplateStudyApplication.class, args);
        log.info("RestTemplateStudyApplication is running...");
    }
}
