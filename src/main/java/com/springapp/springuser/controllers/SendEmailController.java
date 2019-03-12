package com.springapp.springuser.controllers;

import com.springapp.springuser.models.ApplicationUser;
import com.springapp.springuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/send_mail")
public class SendEmailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @GetMapping
    @ResponseBody
    public ResponseEntity sendEmail(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ApplicationUser applicationUser = userRepository.findByUsername(username);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try{
            Context context = new Context();
            String html = templateEngine.process("email", context);

            mimeMessageHelper.setTo(applicationUser.getEmail());
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setSubject("Reminder - Little Bird of Lord Varys");
        }
        catch (MessagingException e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        javaMailSender.send(mimeMessage);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
