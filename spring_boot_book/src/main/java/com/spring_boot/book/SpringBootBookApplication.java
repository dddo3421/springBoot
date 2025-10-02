package com.spring_boot.book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.spring_boot.book"})
@MapperScan(basePackages= {"com.spring_boot.book"})
public class SpringBootBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookApplication.class, args);
	}

}
