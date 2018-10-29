package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.demo.service")
@EnableScheduling
public class GethApItestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GethApItestApplication.class, args);
	}
}
