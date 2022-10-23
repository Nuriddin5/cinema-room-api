package com.nuriddin.myCinemaRoom.controller;


import com.nuriddin.myCinemaRoom.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin/city")
@RequiredArgsConstructor
public class CityController {
    private final CityRepository cityRepository;

    @GetMapping
    public HttpEntity<?> getAllCities() {
        return ResponseEntity.ok(cityRepository.findAll());
    }
}
