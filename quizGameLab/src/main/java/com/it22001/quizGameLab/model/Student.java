package com.it22001.quizGameLab.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sl;

    @Column(unique = true)
    private String studentId;

    // Getters and Setters

    public Long getSl() {
        return sl;
    }

    public void setSl(Long sl) {
        this.sl = sl;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

