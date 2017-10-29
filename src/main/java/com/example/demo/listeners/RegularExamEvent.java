package com.example.demo.listeners;

import com.example.demo.events.GradedEvent;
import com.example.demo.model.Exam;

public class RegularExamEvent extends GradedEvent {

    public RegularExamEvent(Exam exam) {
        super(exam);
    }
}
