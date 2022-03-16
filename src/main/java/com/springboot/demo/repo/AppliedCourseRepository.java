package com.springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.AppliedCourse;

public interface AppliedCourseRepository extends JpaRepository<AppliedCourse,Long> {

}
