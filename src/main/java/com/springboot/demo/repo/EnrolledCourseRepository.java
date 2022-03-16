package com.springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.AppliedCourse;
import com.springboot.demo.model.EnrolledCourse;

public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourse,Long> {

	public void save(AppliedCourse appliedCourse);

}
