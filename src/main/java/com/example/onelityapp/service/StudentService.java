package com.example.onelityapp.service;

import com.example.onelityapp.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student findById(Long studentId);

    List<Student> getAllStudents();

    Student addNewStudent(Student student);

    Student editStudentGrade(Long studentId, Student student);

    void deleteStudent(Long studentId);



}
