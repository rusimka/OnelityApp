package com.example.onelityapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="lesson")
    private String lesson;

    @ManyToMany
    @JoinTable(name = "teacher_student",
    joinColumns = {@JoinColumn(name = "teacher_id")},
    inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> students = new ArrayList<Student>();

    public Teacher(){}

    public Teacher(String firstName, String lastName, String lesson) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lesson = lesson;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
