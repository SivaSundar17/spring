package com.springboot.demo.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.exception.ResourceFoundException;
import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Student;
import com.springboot.demo.repo.StudentRepository;
import com.springboot.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public Student addStudent(Student student) {
		Student local=this.studentRepository.findByStudentEmail(student.getStudentEmail());
		if(local!=null) throw new ResourceFoundException("Student Already Present !!");
		return this.studentRepository.save(student);
	}
	@Override
	public Student filterStudent(long id) {
		this.studentRepository.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("Student not found for id : "+id));
		return this.studentRepository.findById(id).get();
	}
	@Override
	public Student updateStudent(Student student) {
		this.studentRepository.findById(student.getStudentId())
		.orElseThrow(()->new ResourceNotFoundException("Student not found to update in this id : "+student.getStudentId()));
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
		Student student=this.studentRepository.findById(studentId)
				.orElseThrow(()->new ResourceNotFoundException("Student not found for id : "+studentId));
		this.studentRepository.delete(student);

//		Institute institute=new Institute();
//		institute.setInstituteId(instituteId);
//		this.instituteRepository.delete(institute);
	}
	
	
}
