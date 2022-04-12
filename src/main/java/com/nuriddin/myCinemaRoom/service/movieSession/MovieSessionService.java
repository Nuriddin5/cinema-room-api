package com.nuriddin.myCinemaRoom.service.movieSession;


// t.me/superJavaDeveloper 09.04.2022;


import com.nuriddin.myCinemaRoom.dto.MovieSessionDto;
import com.nuriddin.myCinemaRoom.entity.MovieSession;
import org.springframework.http.HttpEntity;

public interface MovieSessionService {
    HttpEntity<?> getAllMovieSessions();

    HttpEntity<?> addNewSession(MovieSessionDto movieSession);




    HttpEntity<?> getMovieSession(Long id);

    HttpEntity<?> deleteMovieSession(Long id);
}
