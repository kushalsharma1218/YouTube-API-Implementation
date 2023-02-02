package com.example.ytapi.models;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class VideoDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String videoId;
    private String videoTitle;
    private String videoDescription;
    private LocalDateTime publishDateTime;
    private String thumbnailDefaultUrl;
    private String thumbnailMediumUrl;
    private String thumbnailHighUrl;
}