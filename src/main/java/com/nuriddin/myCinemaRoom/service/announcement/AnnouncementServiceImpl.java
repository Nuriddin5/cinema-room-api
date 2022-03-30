package com.nuriddin.myCinemaRoom.service.announcement;


// t.me/superJavaDeveloper 30.03.2022;


import com.nuriddin.myCinemaRoom.projection.AnnouncementView;
import com.nuriddin.myCinemaRoom.repository.AnnouncementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService{

private final AnnouncementRepository announcementRepository;

    @Override
    public HttpEntity<?> getAllAnnouncements() {
        return ResponseEntity.ok(announcementRepository.getAllAnnouncements());
    }


    @Override
    public HttpEntity<?> deleteAnnouncement(Long id) {

        boolean existsById = announcementRepository.existsById(id);
        if (existsById) {

            announcementRepository.deleteById(id);

            boolean existsByIdAfterDeleting = announcementRepository.existsById(id);
            if (!existsByIdAfterDeleting) {
                return ResponseEntity.ok().body("Deleted");
            }
            return ResponseEntity.badRequest().body(" problem with Server");

        }
                return ResponseEntity.badRequest().body("not found");

    }

    public HttpEntity<?> getAnnouncement(Long id) {
        Optional<AnnouncementView> announcement = announcementRepository.getAnnouncement(id);
        if (announcement.isPresent()){

        return ResponseEntity.ok(announcementRepository.getAnnouncement(id));
        }else
            return ResponseEntity.status(404).body("Not Found");
    }
}
