package com.example.backapi;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//MapperScan注解指定当前项目的接口地址，在项目启动时候会加载全部的接口
@MapperScan("com.example.backapi.mapper")
public class BackApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackApiApplication.class, args);
	}

}
