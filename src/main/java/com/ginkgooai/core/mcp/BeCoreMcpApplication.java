package com.ginkgooai.core.mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BeCoreMcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeCoreMcpApplication.class, args);
	}

}
