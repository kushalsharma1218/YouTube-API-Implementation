package com.example.ytapi.models;

import java.util.List;

import lombok.Data;


@Data
public class YoutubeResponse {
    private List<YoutubeVideosDetails> items;
}