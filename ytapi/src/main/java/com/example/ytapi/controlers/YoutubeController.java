package com.example.ytapi.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ytapi.models.VideoDetails;
import com.example.ytapi.services.YoutubeService;

@RestController
public class YoutubeController {

    @Autowired
    private YoutubeService youtubeService;


    @GetMapping("/hello")
    public String hello(){
      return "Hello, These are all apis provide only for you:- -/get/videos, /search Note: Both Api accepts pageNumber and pageSize to get paginated response";
    }

    @GetMapping("/get/videos")
    public ResponseEntity<?> getVideos(
      @RequestParam(value =  "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(value =  "pageSize", defaultValue = "5", required = false) Integer pageSize
    ) {
      Page<VideoDetails> listOfVideos = youtubeService.getVideos(pageNumber, pageSize);
      return ResponseEntity.ok(listOfVideos.getContent());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchVideos(
      @RequestParam("query") String query,
      @RequestParam(value =  "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(value =  "pageSize", defaultValue = "5", required = false) Integer pageSize
    ) {
      Page<VideoDetails> listOfVideos = youtubeService.getVideosByQuery(query, pageNumber, pageSize);
      return ResponseEntity.ok(listOfVideos.getContent());
  }
    
}
