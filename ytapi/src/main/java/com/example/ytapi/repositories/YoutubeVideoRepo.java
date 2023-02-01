package com.example.ytapi.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;



import com.example.ytapi.models.YoutubeVideo;

public interface YoutubeVideoRepo extends JpaRepository<YoutubeVideo, Long>{
    Page<YoutubeVideo> findAllByOrderByPublishDateDesc(Pageable pageable);
    Page<YoutubeVideo> findByVideoTitleContainingOrVideoDescriptionContaining(String videoTitle, String videoDescription, Pageable pageable);
}

// @Repository
// public interface VideoRepository extends JpaRepository<Video, Long> {

//   Page<Video> findAllByOrderByPublishDateDesc(Pageable pageable);

//   Page<Video> findByTitleContainingOrDescriptionContaining(String title, String description, Pageable pageable);
// }