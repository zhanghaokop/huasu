package com.huashu.huashuManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class HuashuManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuashuManagerApplication.class, args);
	}
}
