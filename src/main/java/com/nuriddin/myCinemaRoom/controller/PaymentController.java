package com.nuriddin.myCinemaRoom.controller;


// t.me/superJavaDeveloper 30.03.2022;


import com.nuriddin.myCinemaRoom.entity.PurchaseHistory;
import com.nuriddin.myCinemaRoom.entity.Ticket;
import com.nuriddin.myCinemaRoom.enums.PaymentStatus;
import com.nuriddin.myCinemaRoom.enums.TicketStatus;
import com.nuriddin.myCinemaRoom.projection.ViewTickets;
import com.nuriddin.myCinemaRoom.repository.MovieSessionRepository;
import com.nuriddin.myCinemaRoom.repository.PurchaseHistoryRepository;
import com.nuriddin.myCinemaRoom.repository.TicketRepository;
import com.nuriddin.myCinemaRoom.service.ticket.TicketService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Refund;
import com.stripe.model.checkout.Session;
import com.stripe.param.RefundCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor

@RequestMapping(value = "/api/payment")
public class PaymentController {

    @Value("${secret-key}")
    String stripeApiKey;
    private final TicketService ticketService;
    private final TicketRepository ticketRepository;
    private final MovieSessionRepository movieSessionRepository;
    private final PurchaseHistoryRepository purchaseHistoryRepository;



    @GetMapping("/purchase")
    public HttpEntity<?> createStripeSession() throws StripeException {

        Stripe.apiKey = stripeApiKey;
        String userId = "a363fd12-51a9-4da0-8afa-3add7f0cf606";
        List<ViewTickets> allByUserIdAndStatus = ticketRepository.findAllByUserIdAndStatus(UUID.fromString(userId), TicketStatus.NEW);
        List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();
        for (ViewTickets ticket : allByUserIdAndStatus) {

            SessionCreateParams.LineItem.PriceData.ProductData productData = SessionCreateParams.LineItem.PriceData.ProductData.builder().
                    setName(movieSessionRepository.findMovieNameByTicketId(ticket.getId()))
                    .build();
            Double finalPrice = (ticket.getPrice() + 0.3) / (1 - 0.029) * 100;
            SessionCreateParams.LineItem.PriceData priceData = SessionCreateParams.LineItem.PriceData.builder()
                    .setCurrency("Usd")
                    .setUnitAmount(finalPrice.longValue())
                    .setProductData(productData)
                    .build();
            SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
                    .setPriceData(priceData)
                    .setQuantity(1L)
                    .build();
            lineItems.add(lineItem);


        }
        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setClientReferenceId(userId)
                .addAllLineItem(lineItems)
                .setSuccessUrl("http://localhost:8080/api/payment/succeeded")
                .setCancelUrl("http://localhost:8080/api/payment/failed")
                .build();

        Session session = Session.create(params);


        return ResponseEntity.ok().body(session.getUrl());

    }


    @RequestMapping(value = "/api/ticket/get-tickets-in-cart/{userId}", method = RequestMethod.GET)
    public HttpEntity<?> getTicketsInCart(@PathVariable String userId) {

        
        return ticketService.getTicketsInCart(userId);

    }

    @GetMapping("/succeeded")
    public HttpEntity<?> paymentSucceeded() {
        return ResponseEntity.ok("succeeded");

    }
    @GetMapping("/failed")
    public HttpEntity<?> paymentFailed() {
        return ResponseEntity.ok("failed");

    }

    @PostMapping("/refund")
    public HttpEntity<?> refundTickets(@RequestBody List<UUID> ticketUUIDs) throws StripeException {
        Stripe.apiKey = stripeApiKey;
        PurchaseHistory purchaseHistory = purchaseHistoryRepository.getByTicketId(ticketUUIDs.get(0));
        RefundCreateParams params = RefundCreateParams.builder()
                .setPaymentIntent(purchaseHistory.getStripePaymentIntent())
                .build();

        Refund refund = Refund.create(params);
        if (refund.getStatus().equals("succeeded")) {
//            List<UUID> uuidList = ticketDtos.stream().map(TicketDto::getTicketId).toList();
            List<Ticket> ticketList = ticketRepository.findAllById(ticketUUIDs);
            for (Ticket ticket : ticketList) {
                ticket.setStatus(TicketStatus.REFUNDED);
                ticketRepository.save(ticket);
            }
            purchaseHistoryRepository.save(new PurchaseHistory(
                    refund.getAmount(),
                    ticketList,
                    PaymentStatus.REFUNDED,
                    true,
                    refund.getPaymentIntent()
            ));


        }
        return ResponseEntity.ok().body("success");

    }


}
