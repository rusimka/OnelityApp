package com.example.onelityapp.service;

import com.example.onelityapp.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher findById(Long teacherId);

    List<Teacher> getAllTeachers();

    Teacher addNewTeacher(Teacher teacher);

    Teacher addStudentToTeacher(Long teacherId, Long studentId);

    Teacher editTeacherLesson(Long teacherId, Teacher teacher);

    void deleteTeacher(Long teacherId);




}
