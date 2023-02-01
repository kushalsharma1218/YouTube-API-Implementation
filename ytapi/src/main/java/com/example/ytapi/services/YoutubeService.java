package com.example.ytapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ytapi.models.YoutubeVideo;
import com.example.ytapi.repositories.YoutubeVideoRepo;

// api key : AIzaSyBRhETf6a7McMzHXZ-YYCIcm7Hxbjr-tbU
    // @GetMapping("/fetch/videos")
    // public YoutubeModel fetchVideos(){
        
    // }

@Service
public class YoutubeService {

    @Autowired
    YoutubeVideoRepo youtubeVideoRepo;
    
    public Page<YoutubeVideo> getVideosByQuery(String query, Pageable pageable) {
        return youtubeVideoRepo.findByVideoTitleContainingOrVideoDescriptionContaining(query, query, pageable);
    }

    public Page<YoutubeVideo> getVideos(Pageable pageable) {
        return youtubeVideoRepo.findAllByOrderByPublishDateDesc(pageable);
    }
}
