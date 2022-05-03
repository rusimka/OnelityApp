package com.example.onelityapp.model.exceptions;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(Long teacherId) {
        super(String.format("Teacher with id: %d is not found", teacherId));
    }
}
