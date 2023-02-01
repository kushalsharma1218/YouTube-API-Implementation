package com.example.ytapi.models;


import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * Server should call the YouTube API continuously in b
 * ackground (async) with some interval (say 10 seconds) for 
 * fetching the latest videos for a predefined search query and 
 * should store the data of videos (specifically these 
 * fields - Video title, description, publishing datetime, thumbnails URLs and any other fields you require) 
 * in a database with proper indexes.
 * 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class YoutubeVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String videoTitle;
    private String videoDescription;
    private LocalDateTime publishDate;
    private String thumbnailUrl;
    // private thumb
    
}