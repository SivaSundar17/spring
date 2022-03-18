package com.springboot.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.Course;
import com.springboot.demo.model.Institute;

public interface CourseRepository extends JpaRepository<Course,Long> {

	Set<Course> findByInstitute(Institute institute);

	public Course findByCourseName(String courseName);
	
	
}