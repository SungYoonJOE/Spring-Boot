package com.example.demo;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Freeboard;

//@MappedTypes(Freeboard.class)
@MapperScan("com.example.demo.mappers")

@SpringBootApplication
public class MyBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBoardApplication.class, args);
	}

}
