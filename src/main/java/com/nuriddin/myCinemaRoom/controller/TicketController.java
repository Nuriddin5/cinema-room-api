package com.nuriddin.myCinemaRoom.controller;


// t.me/superJavaDeveloper 30.03.2022;


import com.nuriddin.myCinemaRoom.dto.TicketDto;
import com.nuriddin.myCinemaRoom.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class TicketController {
    private final TicketService ticketService;

    @RequestMapping(value = "/api/generate-ticket",method = RequestMethod.POST)
    public HttpEntity<?> generateTicket(@RequestBody TicketDto ticketDto) {

        return ticketService.generateTicket(ticketDto);

    }
}
