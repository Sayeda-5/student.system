package com.student.system.service;

import java.util.List;

import com.student.system.exception.StudentException;
import com.student.system.model.Student;
import com.student.system.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentRepo studentRepository;

    

    @Override
    public List<Student> getAllStudents() throws StudentException{
    	List<Student> list = studentRepository.findAll();
		 
		 if(list ==null) {
			 throw new StudentException("Student not found");
		 }
		return list;
    }

    @Override
    public Student getStudentById(Long id) throws StudentException{
        return studentRepository.findById(id).
        		orElseThrow(() -> new StudentException("Student Not Found With ID :" + id));
    }

    @Override
    public Student addStudent(Student student) throws StudentException{
    	Student s = studentRepository.save(student);
		
		return s;
    }

    @Override
    public Student updateStudent(Student student) throws StudentException {
        studentRepository.findById(student.getId()).
        		orElseThrow(()-> new StudentException("Student Does Not Exist With Id:- "+student.getId()));
		
		return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(Long id) throws StudentException{
    	Student std = studentRepository.findById(id).get();
    	if(std ==null)
    		throw new StudentException("Student Not Found");
    	studentRepository.delete(std);
		
		return std;
	}
}
