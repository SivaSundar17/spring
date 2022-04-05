package com.springboot.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.demo.model.Student;
import com.springboot.demo.model.User;


public interface StudentRepository extends JpaRepository<Student,Long>{

	public Student findByStudentEmail(String studentEmail);

	public Set<Student> findByUser(User user);


}
