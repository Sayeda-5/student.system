package com.student.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.system.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
    @Query("SELECT s FROM Student s")
    List<Student> allStudent();
}

