package com.example.onelityapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@AllArgsConstructor
@Getter // @Getter and @Setter annotations are used to create getter and setter for every fields in this class
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "grade")
    private Integer grade;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers = new ArrayList<Teacher>();




    public Student(){}

    public Student(String firstName, String lastName, Integer grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }
}
