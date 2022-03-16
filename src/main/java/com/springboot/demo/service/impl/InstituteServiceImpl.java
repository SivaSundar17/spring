package com.springboot.demo.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Institute;
import com.springboot.demo.model.Student;
import com.springboot.demo.repo.InstituteRepository;
import com.springboot.demo.service.InstituteService;

@Service
public class InstituteServiceImpl implements InstituteService{
	
	@Autowired
	private InstituteRepository instituteRepository;
	
	@Override
	public Institute addInstitute(Institute institute ) {
		return this.instituteRepository.save(institute);
	}

	@Override
	public Institute updateInstitute(Institute institute) {
		// TODO Auto-generated method stub
		instituteRepository.findById(institute.getInstituteId()).orElseThrow(()->new ResourceNotFoundException("institute not found with id"));
		Institute i1=instituteRepository.findById(institute.getInstituteId()).get();
		institute.setCreatedAt(i1.getCreatedAt());
		return this.instituteRepository.save(institute);
	}

	@Override
	public Set<Institute> getInstitutes() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.instituteRepository.findAll());
	}

	@Override
	public Institute getInstitute(Long academyId) {
		// TODO Auto-generated method stub
		this.instituteRepository.findById(academyId).orElseThrow(() -> new ResourceNotFoundException("institute not found"));
		return this.instituteRepository.findById(academyId).get();
	}

	@Override
	public void deleteInstitute(Long instituteId) {
		// TODO Auto-generated method stub
		this.instituteRepository.findById(instituteId).orElseThrow(() -> new ResourceNotFoundException("institute not found"));
		Institute institute=new Institute();
		institute.setInstituteId(instituteId);
		this.instituteRepository.delete(institute);
	}


}
