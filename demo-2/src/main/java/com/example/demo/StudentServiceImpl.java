package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student old = studentRepository.findById(student.getUid())
				.orElseThrow(()-> new RuntimeException("Student Not Found"));
		
		old.setName(student.getName());
		old.setGender(student.getGender());
		old.setStream(student.getStream());
		
		return studentRepository.save(old);
	}

	@Override
	public void deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).orElse(null);
	}
	
}
