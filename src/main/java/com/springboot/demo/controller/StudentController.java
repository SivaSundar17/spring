package com.springboot.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.model.Student;
import com.springboot.demo.service.StudentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	//get all students
	
	@GetMapping("/viewStudent")
	public Set<Student> getAllStudents()
	{
		return this.studentService.findAll();
	}
	
	//create employee rest api
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student)
	{
		Student student1=this.studentService.addStudent(student);
		 return student1;
	}
	
	//fetch by ID
	@GetMapping("/{studentId}")
	public Student filterStudent(@PathVariable("studentId")long studentId)
	{
		return this.studentService.filterStudent(studentId);
		
	}
	
	//update by Id
	@PutMapping("/editStudent")
	public Student updateStudent(@RequestBody Student student) {
		 return this.studentService.updateStudent(student);
	 }
	
	//delete by id
	@DeleteMapping("/deleteStudent/{studentId}")
	 public void deletestudent(@PathVariable("studentId")Long studentId) {
		this.studentService.deleteStudent(studentId);
	}
}