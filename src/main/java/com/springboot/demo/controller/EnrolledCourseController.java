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

import com.springboot.demo.model.EnrolledCourse;
import com.springboot.demo.service.EnrolledCourseService;


@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class EnrolledCourseController {
	
	@Autowired
	private EnrolledCourseService enrolledCourseService;
	
	@PostMapping("/addEnrolledCourse")
	public EnrolledCourse add(@RequestBody EnrolledCourse enrolledCourse){
		return this.enrolledCourseService.addEnrolledCourse(enrolledCourse);
	}
	
	@PutMapping("/editEnrolledCourse")
	public EnrolledCourse update(@RequestBody EnrolledCourse enrolledCourse){
		return this.enrolledCourseService.updateEnrolledCourse(enrolledCourse);
	}
	
	@GetMapping("/viewEnrolledCourse")
	public Set<EnrolledCourse> enrolledCourses(){
		return this.enrolledCourseService.getEnrolledCourses();
	}
	
	@GetMapping("/{EnrolledId}")
	public EnrolledCourse enrolledCourse(@PathVariable("enrolledId")Long enrolledId) {
		return this.enrolledCourseService.getEnrolledCourse(enrolledId);
	}
	
	@DeleteMapping("/deleteEnrolledCourse/{enrolledId}")
	public void deleteEnrolledCourse(@PathVariable("enrolledId")Long enrolledId) {
		this.enrolledCourseService.deleteEnrolledCourse(enrolledId);
	}
}
