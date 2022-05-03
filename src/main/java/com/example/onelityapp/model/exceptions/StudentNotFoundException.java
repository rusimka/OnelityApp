package com.example.onelityapp.model.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long studentId) {
        super(String.format("Student with id: %d is not found", studentId));
    }
}
