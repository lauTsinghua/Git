package com.cy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableCaching
@EnableAsync
@SpringBootApplication
public class Application {
	//http://localhost:8080/doIndexUI
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
