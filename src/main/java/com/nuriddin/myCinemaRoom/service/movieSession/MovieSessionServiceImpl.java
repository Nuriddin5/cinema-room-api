package com.nuriddin.myCinemaRoom.service.movieSession;


// t.me/superJavaDeveloper 09.04.2022;


import com.nuriddin.myCinemaRoom.dto.MovieSessionDto;
import com.nuriddin.myCinemaRoom.entity.*;
import com.nuriddin.myCinemaRoom.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieSessionServiceImpl implements MovieSessionService {

    final MovieSessionRepository movieSessionRepository;
    final SessionDateRepository sessionDateRepository;
    final TheatreRepository theatreRepository;
    final AnnouncementRepository announcementRepository;
    final SessionTimeRepository sessionTimeRepository;

    @Override
    public HttpEntity<?> getAllMovieSessions() {
        List<MovieSession> movieSessions = movieSessionRepository.findAll();
        if (movieSessions.isEmpty()) {
            return ResponseEntity.ok().body("no movie sessions yet");
        }
        return ResponseEntity.ok().body(movieSessions);
    }

    @Override
    public HttpEntity<?> addNewSession(MovieSessionDto movieSession) {
        List<MovieSession> movieSessionList = movieSessionRepository.findAll();
        LocalTime startTime = LocalTime.parse(movieSession.getStartTime());
        LocalTime endTime = LocalTime.parse(movieSession.getEndTime());
        SessionDate sessionDate = sessionDateRepository.findById(movieSession.getSessionDateId()).get();
        Theatre theatre = theatreRepository.findById(movieSession.getTheatreId()).get();
        Announcement announcement = announcementRepository.findById(movieSession.getAnnouncementId()).get();

        for (MovieSession movieSessionItem : movieSessionList) {
            if (movieSessionItem.getTheatre().getId().equals(theatre.getId()) && movieSessionItem.getSessionDate().equals(sessionDate)) {
                LocalTime startTimeItem = movieSessionItem.getStartTime().getTime();
                LocalTime endTimeItem = movieSessionItem.getEndTime().getTime();
                if ((startTime.compareTo(startTimeItem) > 0 && startTime.compareTo(endTimeItem) < 0)) {
                    return ResponseEntity.ok().body("Movie session already exist in this interval");
                }
                if ((endTime.compareTo(startTimeItem) > 0 && endTime.compareTo(endTimeItem) < 0)) {
                    return ResponseEntity.ok().body("Movie session already exist in this interval");
                }
                if ((startTime.compareTo(startTimeItem) < 0 && endTime.compareTo(endTimeItem) > 0)) {
                    return ResponseEntity.ok().body("Movie session already exist in this interval");
                }
            }
        }

        SessionTime savedStartTime = sessionTimeRepository.save(new SessionTime(startTime));
        SessionTime savedEndTime = sessionTimeRepository.save(new SessionTime(endTime));

        movieSessionRepository.save(new MovieSession(
                theatre,
                sessionDate,
                savedStartTime,
                savedEndTime,
                announcement
        ));
        return ResponseEntity.ok().body("Movie session successfully added");

    }


    @Override
    public HttpEntity<?> getMovieSession(Long id) {
        Optional<MovieSession> movieSessionOptional = movieSessionRepository.findById(id);
        if (movieSessionOptional.isPresent()) {
            return ResponseEntity.ok().body(movieSessionOptional.get());
        }
        return ResponseEntity.status(404).body("not found");
    }

    @Override
    public HttpEntity<?> deleteMovieSession(Long id) {

        if (movieSessionRepository.existsById(id)) {

            movieSessionRepository.deleteById(id);

            boolean existsByIdAfterDeleting = movieSessionRepository.existsById(id);
            if (!existsByIdAfterDeleting) {
                return ResponseEntity.ok().body("Deleted");
            }
            return ResponseEntity.badRequest().body(" problem with Server");

        }


        return ResponseEntity.badRequest().body("not found");

    }


}
