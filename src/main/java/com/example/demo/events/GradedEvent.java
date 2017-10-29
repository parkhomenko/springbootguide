package com.example.demo.events;

import com.example.demo.model.Exam;

public class GradedEvent {

    private Exam exam;

    public GradedEvent(Exam exam) {
        this.exam = exam;
    }

    public Exam getExam() {
        return exam;
    }
}
