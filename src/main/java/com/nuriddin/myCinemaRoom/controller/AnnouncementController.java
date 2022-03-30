package com.nuriddin.myCinemaRoom.controller;


// t.me/superJavaDeveloper 30.03.2022;


import com.nuriddin.myCinemaRoom.service.announcement.AnnouncementServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie-announcement")
public class AnnouncementController {
    private final AnnouncementServiceImpl announcementService;


    @GetMapping
    public HttpEntity<?> getAllAnnouncements() {

        return announcementService.getAllAnnouncements();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getAnnouncement(@PathVariable Long id) {

        return announcementService.getAnnouncement(id);

    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAnnouncement(@PathVariable Long id) {

        return announcementService.deleteAnnouncement(id);

    }




}
