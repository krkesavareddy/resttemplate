package com.hcl.services.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.services.pojo.StudentPojo;
import com.hcl.services.repository.StudentRepo;

@RestController
@RequestMapping("/service")
public class Scontroller {
	
	@Autowired
	StudentRepo studentRepo;

	@PostMapping("/save")
	public String createStudent(@RequestBody StudentPojo studentPojo) {
		System.out.println("come in");
		studentRepo.save(studentPojo);

		
		return "rest template call" ;
				
		
	}
	@GetMapping("/getStudentById/{id}")
	public StudentPojo getStudentById(@PathVariable("id") Long id){
		Optional<StudentPojo> pojos = studentRepo.findById(id);
		StudentPojo sPojo= pojos.get();
		return 	sPojo;
		
	}
	@GetMapping("/getStudentByDate/{date}")
	public List<StudentPojo> getStudentByDate(@PathVariable("date") String date){
		Date d = null;
		List<StudentPojo> students = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			System.out.println("fetching from repo");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		students = studentRepo.findAllByAddmissionDate(d);
		return 	students;
		
		
	}
	
	

}
