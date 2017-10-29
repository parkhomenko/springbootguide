package com.example.demo.listeners;

import com.example.demo.events.CourseWorkGradedEvent;
import com.example.demo.util.SmsUtil;
import com.example.demo.util.SmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    @Autowired
    SmtpService smtpService;

    @Async
    @EventListener
    public void handleCourseWork(CourseWorkGradedEvent event) {
        smtpService.sendMail();
    }

    @Async
    @EventListener
    public void handleRegularExam(RegularExamEvent event) {
        smtpService.sendMail();
    }
}
