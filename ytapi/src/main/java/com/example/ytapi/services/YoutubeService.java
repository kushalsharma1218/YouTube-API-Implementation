package com.example.ytapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ytapi.models.VideoDetails;
import com.example.ytapi.repositories.YoutubeVideoRepo;

// api key : AIzaSyBRhETf6a7McMzHXZ-YYCIcm7Hxbjr-tbU
    // @GetMapping("/fetch/videos")
    // public YoutubeModel fetchVideos(){
        
    // }

@Service
public class YoutubeService {

    @Autowired
    YoutubeVideoRepo youtubeVideoRepo;
    
    public Page<VideoDetails> getVideosByQuery(String query, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return youtubeVideoRepo.findByVideoTitleContainingOrVideoDescriptionContaining(query, query, pageable);
    }

    public Page<VideoDetails> getVideos(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return youtubeVideoRepo.findAllByOrderByPublishDateTimeDesc(pageable);
    }
}
