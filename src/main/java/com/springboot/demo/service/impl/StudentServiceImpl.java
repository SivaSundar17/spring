package com.springboot.demo.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.model.Student;
import com.springboot.demo.repo.StudentRepository;
import com.springboot.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public Student addStudent(Student student) {
		return this.studentRepository.save(student);
	}
	@Override
	public Student filterStudent(long id) {
		return this.studentRepository.findById(id).get();
	}
	@Override
	public Student updateStudent(Student student) {
		Student s1=studentRepository.findById(student.getStudentId()).get();
		student.setCreatedAt(s1.getCreatedAt());
		return this.studentRepository.save(student);
	}
	@Override
	public Set<Student> findAll(){
		return new LinkedHashSet<>(this.studentRepository.findAll());
	}
	@Override
	public void deleteStudent(Long studentId) {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setStudentId(studentId);
		this.studentRepository.delete(student);

//		Institute institute=new Institute();
//		institute.setInstituteId(instituteId);
//		this.instituteRepository.delete(institute);
	}
	
	
}
