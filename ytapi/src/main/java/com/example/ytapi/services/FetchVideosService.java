package com.example.ytapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ytapi.models.YoutubeResponse;
import com.example.ytapi.models.YoutubeVideosDetails;
import com.example.ytapi.models.VideoDetails;
import com.example.ytapi.repositories.YoutubeVideoRepo;

@Service
@Eager
public class FetchVideosService {
    private String baseURL =  "https://www.googleapis.com/youtube/v3/search?part=snippet";
    private static final String API_KEY = "AIzaSyBRhETf6a7McMzHXZ-YYCIcm7Hxbjr-tbU";

    @Autowired
    @Qualifier("youtubeVideoRepo")
    private YoutubeVideoRepo youtubeVideoRepo;
    
    @Autowired
    private RestTemplate restTemplate;

    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(fixedRate = 10000)
    @Async
    public void fetchVideos() {
        String url = baseURL
        + "&q=" + "cricket"
        + "&type=" + "video"
        + "&key=" + API_KEY;

        ResponseEntity<YoutubeResponse> response = null;

        try {
            response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<YoutubeResponse>(){});
        } catch (Exception e){
            System.out.println("Exception occured in fetching videos dur to "+e.getMessage());
            throw e;
        }
        
        YoutubeResponse youtubeResponse = response.getBody();
        List<YoutubeVideosDetails> videos = youtubeResponse.getItems();
        List<VideoDetails> videoDetailsList =  new ArrayList<>();
        for(YoutubeVideosDetails youtubeVideosDetail: videos){
            VideoDetails videoDetails = new VideoDetails();
            videoDetails.setVideoId(youtubeVideosDetail.getId().getVideoId());
            videoDetails.setVideoTitle(youtubeVideosDetail.getSnippet().getTitle());
            videoDetails.setVideoDescription(youtubeVideosDetail.getSnippet().getDescription());
            videoDetails.setThumbnailDefaultUrl(youtubeVideosDetail.getSnippet().getThumbnails().getDefaultData().getUrl());
            videoDetails.setThumbnailMediumUrl(youtubeVideosDetail.getSnippet().getThumbnails().getMedium().getUrl());
            videoDetails.setThumbnailHighUrl(youtubeVideosDetail.getSnippet().getThumbnails().getHigh().getUrl());
            videoDetails.setPublishDateTime(youtubeVideosDetail.getSnippet().getPublishedAt());
            videoDetailsList.add(videoDetails);
        }
        youtubeVideoRepo.saveAll(videoDetailsList);
    }
}