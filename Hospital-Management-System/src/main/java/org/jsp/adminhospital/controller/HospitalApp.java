package org.jsp.adminhospital.controller;

import org.jsp.adminhospital.dto.Hospital;
import org.jsp.adminhospital.dto.ResponseStructure;
import org.jsp.adminhospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/hospital")
public class HospitalApp {
	@Autowired	
	private HospitalService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Hospital>> save(@RequestBody Hospital h){
		return service.saveHospital(h);	
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Hospital>> update (@RequestBody Hospital h){
		return service.saveHospital(h);	
	}
	
}