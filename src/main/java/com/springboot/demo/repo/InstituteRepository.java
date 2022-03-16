package com.springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.Institute;

public interface InstituteRepository extends JpaRepository<Institute,Long> {

}
