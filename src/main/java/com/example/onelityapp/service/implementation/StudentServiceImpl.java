package com.example.onelityapp.service.implementation;

import com.example.onelityapp.model.Student;
import com.example.onelityapp.model.exceptions.StudentNotFoundException;
import com.example.onelityapp.repository.StudentRepository;
import com.example.onelityapp.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long studentId) {
        return this.studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student addNewStudent(Student student) {
        Student newStudent = new Student();
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setGrade(student.getGrade());
        newStudent.setTeachers(student.getTeachers());

        return this.studentRepository.save(newStudent);
    }

    @Override
    public Student editStudentGrade(Long studentId, Student student) {
        Student student1 = this.findById(studentId);
        student1.setGrade(student.getGrade());
        return this.studentRepository.save(student1);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = this.findById(studentId);
        this.studentRepository.delete(student);

    }
}
