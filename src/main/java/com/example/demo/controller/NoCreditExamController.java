package com.example.demo.controller;

import com.example.demo.model.Exam;
import com.example.demo.service.NoCreditExamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoCreditExamController {

    private NoCreditExamService noCreditExamService;

    @RequestMapping(value = "/grade/coursework", method = RequestMethod.POST)
    public void gradeStudent(Exam exam) {

    }
}
