package com.huashu.huashuManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
public class HuashuManagerApplication extends SpringBootServletInitializer {

	/**
	 * 支持传统服务器部署配置
	 * @param builder
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HuashuManagerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HuashuManagerApplication.class, args);
	}
}
