package com.springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.demo.model.Student;


public interface StudentRepository extends JpaRepository<Student,Long>{


}
