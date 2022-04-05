package com.springboot.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.AppliedCourse;
import com.springboot.demo.model.Course;
import com.springboot.demo.model.EnrolledCourse;
import com.springboot.demo.model.Institute;
import com.springboot.demo.model.Student;
import com.springboot.demo.model.User;

public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourse,Long> {

	public void save(AppliedCourse appliedCourse);
	
	Set<EnrolledCourse> findByStudent(Student student);
	
	Set<EnrolledCourse> findByUser(User user);

}
