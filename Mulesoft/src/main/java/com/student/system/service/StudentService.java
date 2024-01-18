package com.student.system.service;

import java.util.List;

import com.student.system.exception.StudentException;
import com.student.system.model.Student;

public interface StudentService {

	public List<Student> getAllStudents() throws StudentException;

	public Student getStudentById(Long id) throws StudentException;

	public Student addStudent(Student student) throws StudentException;

	Student updateStudent(Student student) throws StudentException;
			
    public Student deleteStudent(Long id) throws StudentException;
    

	
}
