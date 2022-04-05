package com.springboot.demo.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

import com.springboot.demo.model.EnrolledCourse;
import com.springboot.demo.model.Student;
import com.springboot.demo.model.User;
import com.springboot.demo.service.StudentService;
import com.springboot.demo.service.EnrolledCourseService;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private EnrolledCourseService enrolledCourseService;
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
	
//	@GetMapping("/user/{id}")
//	public void getStudentsOfUser(@PathVariable("id") Long id){
//		User user=new User();
//		user.setId(id);
//		Set<Student> studentList=this.studentService.getStudentsofUser(user);
//		List<Long> ids=studentList.stream().map(Student::getStudentId).collect(Collectors.toList());
//		List<EnrolledCourse> lst;
//		
//		for (int i=0;i<ids.size();i++) { 
//			Long sid=ids.get(i);
//			Student student=new Student();
//			student.setStudentId(sid);
//			//System.out.println(sid);
//			this.enrolledCourseService.getCourseofStudent(student);
//		
//		}
//		
//		//List<String> field1List = entities.stream().map(YourEntity::getField1).collect(Collectors.toList());
//
//		//entities.stream().map(YourEntity::getField1).collect(Collectors.toList());
//		//return lst; 
//			
//	}
}