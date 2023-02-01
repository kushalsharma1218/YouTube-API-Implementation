package com.example.ytapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/*
Task
- Impemment get api that fetch vudeos fro youtube

- Server should call the YouTube API continuously in background (async) with some interval (say 10 seconds) for fetching the latest videos for a predefined search query and should store the data of videos (specifically these fields - Video title, description, publishing datetime, thumbnails URLs and any other fields you require) in a database with proper indexes.
- A GET API which returns the stored video data in a paginated response sorted in descending order of published datetime.
- A basic search API to search the stored videos using their title and description.
- Dockerize the project.
- It should be scalable and optimised.


 */


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class YtapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YtapiApplication.class, args);
	}

}