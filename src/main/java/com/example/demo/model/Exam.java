package com.example.demo.model;

import javax.persistence.Entity;

@Entity
public class Exam {

    private long id;
    private String name;
    private int grade;

    public Exam(int id, String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
