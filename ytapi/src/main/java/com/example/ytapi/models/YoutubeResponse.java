package com.example.ytapi.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YoutubeResponse {
    private List<YoutubeVideo> videos;
}