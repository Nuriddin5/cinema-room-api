package com.nuriddin.myCinemaRoom.service.ticket;


// t.me/superJavaDeveloper 30.03.2022;

//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.Entity;
//import java.util.UUID;
//
//@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity

import com.nuriddin.myCinemaRoom.dto.TicketDto;
import com.nuriddin.myCinemaRoom.entity.MovieSession;
import com.nuriddin.myCinemaRoom.entity.Ticket;
import com.nuriddin.myCinemaRoom.enums.TicketStatus;
import com.nuriddin.myCinemaRoom.repository.MovieSessionRepository;
import com.nuriddin.myCinemaRoom.repository.SeatRepository;
import com.nuriddin.myCinemaRoom.repository.TicketRepository;
import com.nuriddin.myCinemaRoom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final MovieSessionRepository movieSessionRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;
    @Override
    public HttpEntity<?> generateTicket(TicketDto ticketDto) {
        MovieSession movieSession = movieSessionRepository.findById(ticketDto.getSessionId()).get();
        Ticket ticket = new Ticket(
                movieSession,
                seatRepository.findById(ticketDto.getSeatId()).get(),
                movieSession.getAnnouncement().getMovie_contract().getMinPricePerSeat(),
                TicketStatus.NEW,
                userRepository.findByUsername("nur")
                );
        Ticket generatedTicket = ticketRepository.save(ticket);
        UUID id = generatedTicket.getId();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Ticket ticket1 = ticketRepository.findById(id).get();
                if (ticket1.getStatus().equals(TicketStatus.NEW)) {
                    ticketRepository.delete(ticket1);
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 30000L);
        return null;
    }
}
