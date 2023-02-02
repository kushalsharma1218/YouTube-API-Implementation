package com.example.ytapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Thumbnails {
    private ThumbnailMetaData high;
    @JsonProperty("default") 
    private ThumbnailMetaData defaultData;
    private ThumbnailMetaData medium;

}
