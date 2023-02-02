package com.example.ytapi.repositories;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ytapi.models.VideoDetails;


@Qualifier("youtubeVideoRepo")
public interface YoutubeVideoRepo extends JpaRepository<VideoDetails, Long> {
    Page<VideoDetails> findAllByOrderByPublishDateTimeDesc(Pageable pageable);
    Page<VideoDetails> findByVideoTitleContainingOrVideoDescriptionContaining(String videoTitle, String videoDescription, Pageable pageable);
}