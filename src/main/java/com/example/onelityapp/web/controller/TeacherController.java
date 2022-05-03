package com.example.onelityapp.web.controller;

import com.example.onelityapp.model.Teacher;
import com.example.onelityapp.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/all-teachers")
    public List<Teacher> getAllTeachers() {
        return this.teacherService.getAllTeachers();
    }

    @PostMapping("/create-teacher")
    public Teacher addNewTeacher(@RequestBody Teacher teacher) {
        return this.teacherService.addNewTeacher(teacher);
    }

    @PutMapping("add-student-for-teacher/{teacherId}/{studentId}")
    public Teacher addStudentToTeacher(@PathVariable Long teacherId, @PathVariable Long studentId) {
        return this.teacherService.addStudentToTeacher(teacherId,studentId);
    }

    /*
    In the @RequestBody Teacher teacher, we can pass all arguments for teacher or we can pass just lesson,
    but the service is only updating the lesson attribute
     */
    @PutMapping("edit-lesson/{teacherId}")
    public Teacher editTeacherLesson(@PathVariable Long teacherId, @RequestBody Teacher teacher) {
        return this.teacherService.editTeacherLesson(teacherId,teacher);
    }

    @DeleteMapping("/delete-teacher/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId) {
        this.teacherService.deleteTeacher(teacherId);
    }
}
