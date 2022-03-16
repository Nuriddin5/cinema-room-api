package com.nuriddin.myCinemaRoom.interfaces;

import org.springframework.http.HttpEntity;

import java.util.UUID;

public interface MovieInterface {

    HttpEntity<?> getAllMovies(int size, int page, String search, String sort, Boolean direction);

    HttpEntity<?> getMovieById(UUID id);

    HttpEntity<?> saveMovie();



}

