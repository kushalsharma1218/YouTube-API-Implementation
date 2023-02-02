package com.example.ytapi.models;

import java.time.LocalDateTime;
import lombok.Data;

@Data 
public class Snippet {
    private String title;
    private String description;
    private LocalDateTime publishedAt;
    private Thumbnails thumbnails;

}
