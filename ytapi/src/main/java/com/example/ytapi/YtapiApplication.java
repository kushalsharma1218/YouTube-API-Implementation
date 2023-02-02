package com.example.ytapi;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class YtapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YtapiApplication.class, args);
	}

	@Bean
	public TaskExecutor getAsynExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setMaxPoolSize(1000);
		threadPoolTaskExecutor.setCorePoolSize(30);
		threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		threadPoolTaskExecutor.setThreadNamePrefix("Async Thread - ");
		return threadPoolTaskExecutor;
	}


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}