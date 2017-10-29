package com.example.demo.service;

import com.example.demo.model.Exam;
import com.example.demo.repository.ExamRepository;
import com.example.demo.util.SmsUtil;
import com.example.demo.util.SmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseWorkService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    CreditCalculator creditCalculator;

    @Autowired
    SmsUtil smsUtil;

    @Autowired
    SmtpService smtpService;

    public void gradeStudent(Exam exam) {
        examRepository.save(exam);

        sendEmail();

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

    private void sendEmail() {
        SmtpService smtpService = new SmtpService();
        smtpService.sendMail();
    }
}
