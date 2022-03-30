package com.nuriddin.myCinemaRoom.service.announcement;

import org.springframework.http.HttpEntity;

public interface AnnouncementService {

    HttpEntity<?> getAllAnnouncements();

    HttpEntity<?> getAnnouncement(Long id);

    HttpEntity<?> deleteAnnouncement(Long id);
}
