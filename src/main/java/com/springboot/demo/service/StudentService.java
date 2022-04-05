package com.springboot.demo.service;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import com.springboot.demo.model.Student;
import com.springboot.demo.model.User;

public interface StudentService {

	public Student addStudent(Student student);


	public Set<Student> findAll();


	public Student filterStudent(long studentId);


	public Student updateStudent(Student student);


	void deleteStudent(Long studentId);


	public Set<Student> getStudentsofUser(User user);



}
