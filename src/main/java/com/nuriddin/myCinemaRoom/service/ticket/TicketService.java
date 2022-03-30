package com.nuriddin.myCinemaRoom.service.ticket;

import com.nuriddin.myCinemaRoom.dto.TicketDto;
import com.nuriddin.myCinemaRoom.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service

public interface TicketService {
    HttpEntity<?> generateTicket(TicketDto ticketDto);
}
