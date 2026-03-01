package com.example.demo;

import java.util.List;

public interface StudentService {
	Student createStudent(Student student);
	List<Student> getAllStudents();
	Student updateStudent(Student student);
	void deleteStudentById(Integer id);
	Student getStudentById(Integer id);
	
}
