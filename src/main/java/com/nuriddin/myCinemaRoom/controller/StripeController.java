package com.nuriddin.myCinemaRoom.controller;


// t.me/superJavaDeveloper 01.04.2022;


import com.nuriddin.myCinemaRoom.entity.PurchaseHistory;
import com.nuriddin.myCinemaRoom.entity.Ticket;
import com.nuriddin.myCinemaRoom.enums.PaymentStatus;
import com.nuriddin.myCinemaRoom.enums.TicketStatus;
import com.nuriddin.myCinemaRoom.projection.ViewTickets;
import com.nuriddin.myCinemaRoom.repository.PurchaseHistoryRepository;
import com.nuriddin.myCinemaRoom.repository.TicketRepository;
import com.nuriddin.myCinemaRoom.service.mail.MailServiceImpl;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.StripeObject;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

@RequestMapping(value = "/stripe")
public class StripeController {

    private final TicketRepository ticketRepository;
    private final PurchaseHistoryRepository purchaseHistoryRepository;
    private final MailServiceImpl mailService;

    @Value("${secret-key}")
    String stripeApiKey;

    String endPointSecret = "whsec_1c66e44b9e9599db7cd1595e5e637c58fb228251d461fca1613fa9b62da4b897";

    @PostMapping()
    public Object handle(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) throws SignatureVerificationException {
        Stripe.apiKey = stripeApiKey;
        Event event = null;
        event = Webhook.constructEvent(payload, sigHeader, endPointSecret);

        if (event.getType().equals("checkout.session.completed")) {
            Session session = (Session) event.getDataObjectDeserializer().getObject().get();

            fulfillOrder(session);
        }
        return "";
    }

    private void fulfillOrder(Session session) {



        String clientReferenceId = session.getClientReferenceId();
        List<ViewTickets> ticketList = ticketRepository.findAllByUserIdAndStatus(UUID.fromString(clientReferenceId), TicketStatus.NEW);
        List<UUID> collect = ticketList.stream().map(ViewTickets::getId).toList();
        List<Ticket> allById = ticketRepository.findAllById(collect);
        for (Ticket ticket : allById) {
            ticket.setStatus(TicketStatus.PURCHASED);
            ticketRepository.save(ticket);
        }

        Thread thread = new Thread(() -> {
            mailService.sendEmail(allById, "nuriddinqurbonboyev52@gmail.com");
        });
        thread.start();

        purchaseHistoryRepository.save(new PurchaseHistory(session.getAmountTotal(), allById, PaymentStatus.PAID, false, session.getPaymentIntent()));



    }
}
