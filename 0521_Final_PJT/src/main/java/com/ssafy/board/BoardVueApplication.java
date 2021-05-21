package com.ssafy.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
public class BoardVueApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BoardVueApplication.class, args);
	}

}
