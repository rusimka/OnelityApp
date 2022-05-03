package com.example.onelityapp.web.controller;

import com.example.onelityapp.model.Student;
import com.example.onelityapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create-student")
    public Student addNewStudent(@RequestBody Student student) {
        return this.studentService.addNewStudent(student);
    }

    @PutMapping("/edit-student-grade/{studentId}")
    public Student editStudentGrade(@PathVariable Long studentId, @RequestBody Student student) {
        return this.studentService.editStudentGrade(studentId,student);
    }

    @DeleteMapping("/delete-student/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        this.studentService.deleteStudent(studentId);
    }
}
