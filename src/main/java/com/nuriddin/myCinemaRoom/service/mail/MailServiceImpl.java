package com.nuriddin.myCinemaRoom.service.mail;


// t.me/superJavaDeveloper 05.04.2022;


import com.nuriddin.myCinemaRoom.entity.Movie;
import com.nuriddin.myCinemaRoom.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;
    @Autowired
    TemplateEngine templateEngine;

    @Override
    public HttpEntity<?> sendEmail(List<Ticket> tickets, String userEmail) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            String s = "C:\\Users\\zuxra\\Desktop\\JavaAllCodes\\40 InshaAlloh\\Spring learning 1h\\DemoForEmail-04-04-2022\\src\\main\\resources\\files\\SAVE_20220314_231557-02.jpeg";
            String from = "zuxramavlyanova@gmail.com";
            helper.setFrom(from);
            helper.setTo(userEmail);
            helper.setSubject("Purchased tickets");

            Map<String, Object> variables = new HashMap<>();
//            variables.put("message", sendMsgDto.getText());
            variables.put("ticketList", tickets);


            Context context = new Context();
            context.setVariables(variables);

            String p = templateEngine.process("email-template.html", context);
            helper.setText(p, true);



//            FileSystemResource file
//                    = new FileSystemResource(new File(emailDto.getPathToAttachment()));
//            helper.addAttachment("Invoice", file);

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
