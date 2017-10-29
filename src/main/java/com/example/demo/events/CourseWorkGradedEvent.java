package com.example.demo.events;

import com.example.demo.model.Exam;

public class CourseWorkGradedEvent extends GradedEvent {

    public CourseWorkGradedEvent(Exam exam) {
        super(exam);
    }
}
