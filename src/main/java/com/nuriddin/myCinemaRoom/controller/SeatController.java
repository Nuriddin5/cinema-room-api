package com.nuriddin.myCinemaRoom.controller;


// t.me/superJavaDeveloper 30.03.2022;


import com.nuriddin.myCinemaRoom.service.seat.AvailableSeats;
import com.nuriddin.myCinemaRoom.service.seat.AvailableSeatsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/available-seats")
@RequiredArgsConstructor

public class SeatController {
    private final AvailableSeats availableSeats;
    @GetMapping("/{sessionId}")
    public HttpEntity<?> getAvailableSeatsInSession(@PathVariable Long sessionId) {

        return availableSeats.getAvailableSeatsInSession(sessionId);

    }
}
