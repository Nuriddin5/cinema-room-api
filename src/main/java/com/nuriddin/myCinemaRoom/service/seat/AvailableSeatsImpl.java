package com.nuriddin.myCinemaRoom.service.seat;


// t.me/superJavaDeveloper 30.03.2022;

 

import com.nuriddin.myCinemaRoom.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AvailableSeatsImpl implements AvailableSeats {

    private final SeatRepository seatRepository;

    @Override
    public HttpEntity<?> getAvailableSeatsInSession(Long sessionId) {

        return ResponseEntity.ok().body(seatRepository.getAvailableSeatsInSession(sessionId));


    }
}
