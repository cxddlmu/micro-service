package com.lovnx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.Async;

@EnableDiscoveryClient
@SpringBootApplication
public class A_Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(A_Application.class).web(true).run(args);
	}

	@Async("threadPoolTaskExecutor")
	public void asyncMethodWithConfiguredExecutor() {
		System.out.println("Execute method with configured executor - "
								   + Thread.currentThread().getName());
	}

}
