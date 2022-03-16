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

import com.springboot.demo.model.Course;
import com.springboot.demo.model.Institute;
import com.springboot.demo.service.CourseService;

@RestController
@CrossOrigin("*")
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/addCourse")
	public Course add(@RequestBody Course course){
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/editCourse")
	public Course update(@RequestBody Course course){
		return this.courseService.updateCourse(course);
	}
	
	@GetMapping("/viewCourse")
	public Set<Course> courses(){
		return this.courseService.getCourses();
	}
	
	@GetMapping("/{courseId}")
	public Course course(@PathVariable("courseId")Long courseId) {
		return this.courseService.getCourse(courseId);
	}
	
	@DeleteMapping("/deleteCourse/{courseId}")
	public void deleteCourse(@PathVariable("courseId")Long courseId) {
		this.courseService.deleteCourse(courseId);
	}
	

	 @GetMapping("/institute/{instituteId}")
		public Set<Course> getCoursesOfInstitute(@PathVariable("instituteId") Long instituteId){
			Institute institute=new Institute();
			institute.setInstituteId(instituteId);
			Set<Course>coursesOfInstitute=this.courseService.getCoursesOfInstitute(institute);
			return coursesOfInstitute;
			
		}
}