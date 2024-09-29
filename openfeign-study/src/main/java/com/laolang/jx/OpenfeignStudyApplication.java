package com.laolang.jx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients(basePackages = {"com.laolang.jx.remote"})
@SpringBootApplication
public class OpenfeignStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignStudyApplication.class, args);
        log.info("OpenfeignStudyApplication is running...");
    }
}
