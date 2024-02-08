package com.synthilearn.workspaceservice;

import com.synthilearn.loggingstarter.EnableLogging;
import com.synthilearn.securestarter.EnableTokenResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableLogging
@EnableTokenResolver
public class WorkspaceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkspaceServiceApplication.class, args);
	}

}
