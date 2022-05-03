package com.example.onelityapp.repository;

import com.example.onelityapp.model.Student;
import com.example.onelityapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
