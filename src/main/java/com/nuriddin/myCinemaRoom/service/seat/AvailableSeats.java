package com.nuriddin.myCinemaRoom.service.seat;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public interface AvailableSeats {

   HttpEntity<?> getAvailableSeatsInSession(Long sessionId);
}
