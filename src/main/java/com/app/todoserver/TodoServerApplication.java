package com.app.todoserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TodoServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TodoServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
