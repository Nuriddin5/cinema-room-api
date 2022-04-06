package com.nuriddin.myCinemaRoom.service.ticket;

import com.nuriddin.myCinemaRoom.dto.TicketDto;
import com.nuriddin.myCinemaRoom.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface TicketService {
    HttpEntity<?> generateTicket(TicketDto ticketDto);

    HttpEntity<?> refundTickets(List<TicketDto> ticketDto);

    HttpEntity<?> getTicketsInCart(String userId);
}
