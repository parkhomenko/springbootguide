package com.example.demo.controller;

import com.example.demo.model.Exam;
import com.example.demo.service.CourseWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseWorkController {

    @Autowired
    private CourseWorkService courseWorkService;

    @RequestMapping(value = "/grade/coursework", method = RequestMethod.POST)
    public void gradeStudent(Exam exam) {

    }

}
