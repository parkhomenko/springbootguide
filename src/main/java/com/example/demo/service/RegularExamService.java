package com.example.demo.service;

import com.example.demo.model.Exam;
import com.example.demo.repository.ExamRepository;
import com.example.demo.util.SmsUtil;
import com.example.demo.util.SmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegularExamService {

    @Autowired
    private ExamRepository examRepository;

    public void gradeStudent(Exam exam) {
        examRepository.save(exam);

        sendMail();

        sendSms();

        calculateCredits();
    }

    private void calculateCredits() {
        CreditCalculator creditCalculator = new CreditCalculator();
        creditCalculator.calculate();
    }

    private void sendSms() {
        SmsUtil smsUtil = new SmsUtil();
        smsUtil.sendSms();
    }

    private void sendMail() {
        SmtpService smtpService = new SmtpService();
        smtpService.sendMail();
    }

}
