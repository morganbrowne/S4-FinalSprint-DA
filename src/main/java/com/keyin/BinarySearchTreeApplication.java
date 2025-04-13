package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.keyin")
public class BinarySearchTreeApplication {
    public static void main(String[] args) {
        SpringApplication.run(BinarySearchTreeApplication.class, args);
    }
}