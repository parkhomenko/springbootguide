package com.example.demo.service;

import com.example.demo.model.Exam;
import com.example.demo.repository.ExamRepository;
import com.example.demo.util.SmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoCreditExamService {

    @Autowired
    private ExamRepository examRepository;

    public void gradeStudent(Exam exam) {
        examRepository.save(exam);

        sendEmail();
    }

    private void sendEmail() {
        SmtpService smtpService = new SmtpService();
        smtpService.sendMail();
    }
}
