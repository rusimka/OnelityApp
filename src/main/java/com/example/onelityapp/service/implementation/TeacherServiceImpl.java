package com.example.onelityapp.service.implementation;

import com.example.onelityapp.model.Student;
import com.example.onelityapp.model.Teacher;
import com.example.onelityapp.model.exceptions.TeacherNotFoundException;
import com.example.onelityapp.repository.TeacherRepository;
import com.example.onelityapp.service.StudentService;
import com.example.onelityapp.service.TeacherService;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository; // dependency injection
    private final StudentService studentService;

    public TeacherServiceImpl(TeacherRepository teacherRepository, StudentService studentService) {
        this.teacherRepository = teacherRepository;
        this.studentService = studentService;
    }

    @Override
    public Teacher findById(Long teacherId) {
        return this.teacherRepository.findById(teacherId).orElseThrow(() -> new TeacherNotFoundException(teacherId));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Teacher addNewTeacher(Teacher teacher) {
       Teacher newTeacher = new Teacher();
       newTeacher.setTeacherId(teacher.getTeacherId());
       newTeacher.setFirstName(teacher.getFirstName());
       newTeacher.setLastName(teacher.getLastName());
       newTeacher.setLesson(teacher.getLesson());
       return this.teacherRepository.save(newTeacher);
    }

    // to add connection between Teacher and Student, to fill the joining table teacher_students
    @Override
    public Teacher addStudentToTeacher(Long teacherId, Long studentId) {
        Teacher teacher = this.findById(teacherId); // 'this' keyword refers to function 'findById(teacherId)' is this Service implementation
        Student student = studentService.findById(studentId);
        teacher.getStudents().add(student);
        return this.teacherRepository.save(teacher);
    }


    @Override
    public Teacher editTeacherLesson(Long teacherId, Teacher teacher) {
        Teacher teacher1 = this.findById(teacherId);
        teacher1.setLesson(teacher.getLesson());
        return this.teacherRepository.save(teacher1);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        Teacher teacher = this.findById(teacherId);
        this.teacherRepository.delete(teacher);

    }


}
