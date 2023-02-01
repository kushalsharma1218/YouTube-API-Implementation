package com.example.ytapi.services;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ytapi.models.YoutubeResponse;
import com.example.ytapi.models.YoutubeVideo;
import com.example.ytapi.repositories.YoutubeVideoRepo;


/*
 * &fields=items(id(videoId),snippet(title,description,publishedAt,thumbnails(default)))"
 */
@EnableAsync
@Service
public class FetchVideosService {

    // private static final Logger logger = LoggerFactory.getLogger(FetchVideosService.class);
   

    private String baseURL =  "https://www.googleapis.com/youtube/v3/search?part=snippet";
    private static final String API_KEY = "AIzaSyBRhETf6a7McMzHXZ-YYCIcm7Hxbjr-tbU";

    @Autowired
    private YoutubeVideoRepo videoRepository;
    
    @Autowired
    private RestTemplate restTemplate;


    @Async
    @Scheduled(fixedRate = 1000)
    public void fetchVideos(String searchQuery, String type) {
        System.out.println("Called init");
        System.out.println();
        String url = baseURL
        + "&q=" + searchQuery
        + "&type=" + type
        + "&key=" + API_KEY;
  
        // ResponseEntity<YoutubeResponse> response = restTemplate.getForEntity(url, YoutubeResponse.class);
        // YoutubeResponse youtubeResponse = response.getBody();
        // List<YoutubeVideo> videos = youtubeResponse.getVideos();
        // videoRepository.saveAll(videos);
        System.out.println("Finished");
    }
}


/*
 YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), request -> {})
                .setApplicationName("YouTube API Java Client")
                .build();

            YouTube.Search.List search = youtube.search().list("id,snippet");

            search.setKey("YOUR_API_KEY");
            search.setQ(searchQuery);
            search.setType("video");
            search.setFields("items(id(videoId),snippet(title,description,publishedAt,thumbnails(default)))");
            search.setMaxResults(10L);

            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();

            for (SearchResult searchResult : searchResultList) {
            Video video = new Video();
            video.setTitle(searchResult.getSnippet().getTitle());
            video.setDescription(searchResult.getSnippet().getDescription());
            video.setPublishDateTime(searchResult.getSnippet().getPublishedAt().toInstant());
            video.setThumbnails(searchResult.getSnippet().getThumbnails().getDefault().getUrl());
            videoRepository.save(video);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 */
