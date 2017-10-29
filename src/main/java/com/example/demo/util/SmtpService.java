package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class SmtpService {

    public void sendMail() {
        System.out.println("Mail has been sent");
    }
}
