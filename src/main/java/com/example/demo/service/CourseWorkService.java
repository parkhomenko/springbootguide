package com.example.demo.service;

import com.example.demo.events.CourseWorkGradedEvent;
import com.example.demo.model.Exam;
import com.example.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CourseWorkService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    public void gradeStudent(Exam exam) {
        examRepository.save(exam);

        publisher.publishEvent(new CourseWorkGradedEvent(exam));
    }
}
