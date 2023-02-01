package com.example.ytapi.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ytapi.models.YoutubeVideo;
import com.example.ytapi.services.YoutubeService;

@RestController
public class YoutubeController {

    @Autowired
    YoutubeService youtubeService;


    @GetMapping("/hello")
    public String hello(){
      return "hello";
    }

    @GetMapping("/get/videos")
    public Page<YoutubeVideo> getVideos(Pageable pageable) {
    return youtubeService.getVideos(pageable);
  }

    @GetMapping("/search")
    public Page<YoutubeVideo> searchVideos(@RequestParam("q") String query, Pageable pageable) {
        return youtubeService.getVideosByQuery(query, pageable);
  }
    
}
