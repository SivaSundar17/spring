package com.springboot.demo.service;

import java.util.Set;

import com.springboot.demo.model.EnrolledCourse;

public interface EnrolledCourseService {

	public EnrolledCourse addEnrolledCourse(EnrolledCourse enrolledCourse);

	public EnrolledCourse updateEnrolledCourse(EnrolledCourse enrolledCourse);

	public Set<EnrolledCourse> getEnrolledCourses();

	public EnrolledCourse getEnrolledCourse(Long enrolledId);

	public void deleteEnrolledCourse(Long enrolledId);

}
