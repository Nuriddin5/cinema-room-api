package com.nuriddin.myCinemaRoom.service.mail;

import com.nuriddin.myCinemaRoom.entity.Ticket;
import org.springframework.http.HttpEntity;

import java.util.List;
import java.util.UUID;

public interface MailService {
    HttpEntity<?> sendEmail(List<Ticket> tickets, String userEmail);

}
