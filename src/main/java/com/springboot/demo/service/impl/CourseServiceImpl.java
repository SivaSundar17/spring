package com.springboot.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.model.Course;
import com.springboot.demo.model.Institute;
import com.springboot.demo.repo.CourseRepository;
import com.springboot.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return this.courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		
		Course c1=courseRepository.findById(course.getCourseId()).get();
		course.setCreatedAt(c1.getCreatedAt());
		return this.courseRepository.save(course);
	}

	@Override
	public Set<Course> getCourses() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.courseRepository.findAll());
	}

	@Override
	public Course getCourse(Long courseId) {
		// TODO Auto-generated method stub
		return this.courseRepository.findById(courseId).get();
	}

	@Override
	public void deleteCourse(Long courseId) {
		// TODO Auto-generated method stub
		Course course =new Course();
		course.setCourseId(courseId);
		this.courseRepository.delete(course);
		
	}
	@Override
	public Set<Course> getCoursesOfInstitute(Institute institute)
	{
		return this.courseRepository.findByInstitute(institute);
	}

}