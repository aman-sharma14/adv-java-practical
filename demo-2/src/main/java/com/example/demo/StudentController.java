package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/addstudent")
	public String showAddForm(Model model) {
		
		model.addAttribute("student", new Student());
		
		return "addstudent";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		service.createStudent(student);
		
		return "redirect:viewAllStudents";
	}
	
	@GetMapping("/viewAllStudents")
	public String viewAllStudents(Model model) {
		model.addAttribute("allStudents", service.getAllStudents());
		return "viewallstudents";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent() {
		return "deletestudent";
	}
	
	@PostMapping("/deleteStudent")
	public String deleteStudent(@RequestParam Integer id) {
		
		service.deleteStudentById(id);
		
		return "redirect:/viewAllStudents";
	}
	
	@GetMapping("/deleteStudentById/{id}")
	public String deleteStudentById(@PathVariable Integer id) {
		service.deleteStudentById(id);
		return "redirect:/viewAllStudents";
	}
	
	@GetMapping("/updateStudentForm/{id}")
	public String updateStudentForm(@PathVariable Integer id, Model model) {
		
		Student student = service.getStudentById(id);
		
		model.addAttribute("student", student);
		
		return "updatestudent";
	}
	
	@PostMapping("/saveupdate")
	public String saveUpdate(@ModelAttribute("student")Student student) {
		
		service.updateStudent(student);
		
		return "redirect:/viewAllStudents";
	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
}
