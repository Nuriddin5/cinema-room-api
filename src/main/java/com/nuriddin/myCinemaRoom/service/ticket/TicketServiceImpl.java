package com.nuriddin.myCinemaRoom.service.ticket;


// t.me/superJavaDeveloper 30.03.2022;

 

import com.nuriddin.myCinemaRoom.dto.TicketDto;
import com.nuriddin.myCinemaRoom.entity.MovieSession;
import com.nuriddin.myCinemaRoom.entity.Ticket;
import com.nuriddin.myCinemaRoom.enums.TicketStatus;
import com.nuriddin.myCinemaRoom.projection.ViewTickets;
import com.nuriddin.myCinemaRoom.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
//    @Override
//    public HttpEntity<?> refundTickets(List<TicketDto> ticketDto) {
//        RefundCreateParams params = RefundCreateParams
//                .builder()
//                .setPaymentIntent("")
//                .build();
//
//        try {
//            Refund refund = Refund.create(params);
//            if (refund.getStatus().equals("succeeded")) {
//                // TODO: 31.03.2022
//            }
//        } catch (StripeException e) {
//            e.printStackTrace();
//        }
//    }



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
                movieSession.getAnnouncement().getMovieContract().getMinPricePerSeat(),
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
        timer.schedule(timerTask, 300000L);
        return null;
    }

    @Override
    public HttpEntity<?> refundTickets(List<TicketDto> ticketDto) {
        return null;
    }

    @Override
    public HttpEntity<?> getTicketsInCart(String userId) {
        List<ViewTickets> allByUserIdAndStatus = ticketRepository.findAllByUserIdAndStatus(UUID.fromString(userId), TicketStatus.NEW);

        return ResponseEntity.ok().body(allByUserIdAndStatus);
    }
}
