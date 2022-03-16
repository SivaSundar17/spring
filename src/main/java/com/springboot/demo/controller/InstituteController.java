package com.springboot.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Institute;
import com.springboot.demo.service.InstituteService;
import java.util.Optional;


@RestController
@RequestMapping("/institute")
@CrossOrigin("*")
public class InstituteController {
	
	@Autowired
	private InstituteService instituteService;
	
	 @PostMapping("/addInstitute")
	 public Institute addInstitute(@RequestBody Institute institute){
		 Institute institute1=this.instituteService.addInstitute(institute);
		 return institute1;
	 }
	 
	 @GetMapping("/{instituteId}")
	 public Institute getinstitute(@PathVariable("instituteId")Long instituteId) {
		 return this.instituteService.getInstitute(instituteId);
	 }
	 
	 @GetMapping("/viewInstitute")
	 public Set<Institute> getInstitute(){
		 return this.instituteService.getInstitutes();
	 }
	 
	 @PutMapping("/editInstitute")
	 public Institute updateInstitute(@RequestBody Institute institute) {
		 return this.instituteService.updateInstitute(institute);
	 }
	 
	 @DeleteMapping("/deleteInstitute/{instituteId}")
	 public void deleteinstitute(@PathVariable("instituteId")Long instituteId) {
		 this.instituteService.deleteInstitute(instituteId);
	 }
}
