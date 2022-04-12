package com.nuriddin.myCinemaRoom.controller;


// t.me/superJavaDeveloper 09.04.2022;

import com.nuriddin.myCinemaRoom.dto.MovieSessionDto;
import com.nuriddin.myCinemaRoom.entity.MovieSession;
import com.nuriddin.myCinemaRoom.repository.MovieSessionRepository;
import com.nuriddin.myCinemaRoom.service.movieSession.MovieSessionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerTypePredicate;

 
@RestController()
@RequestMapping("api/admin/movie-session")
@RequiredArgsConstructor
public class MovieSessionController {
    final
    MovieSessionServiceImpl movieSessionService;



    @GetMapping
    public HttpEntity<?> getAllMovieSessions() {
        return movieSessionService.getAllMovieSessions();
    }

    @GetMapping("{id}")
    public HttpEntity<?> getMovieSession(@PathVariable Long id) {
        return movieSessionService.getMovieSession(id);
    }

    @DeleteMapping("{id}")
    public HttpEntity<?> deleteMovieSession(@PathVariable Long id) {
        return movieSessionService.deleteMovieSession(id);
    }

    @PostMapping()
    public HttpEntity<?> addMovieSession(@RequestBody MovieSessionDto movieSession) {
        return movieSessionService.addNewSession(movieSession);
    }




}
