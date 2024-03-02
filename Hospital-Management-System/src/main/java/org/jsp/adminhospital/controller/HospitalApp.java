package org.jsp.adminhospital.controller;

import org.jsp.adminhospital.dto.Hospital;
import org.jsp.adminhospital.dto.ResponseStructure;
import org.jsp.adminhospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> findbyid (@PathVariable int id){
		return service.findById(id);	
	}
	@PostMapping("/verify-by-phone")
	public ResponseEntity<ResponseStructure<Hospital>> verifyByPhone(@RequestParam long phone,
			@RequestParam String password) {
		return service.verify(phone, password);
	}

	@PostMapping("/verify-by-email")
	public ResponseEntity<ResponseStructure<Hospital>> verifyByEmail(@RequestParam String email,
			@RequestParam String password) {
		return service.verify(email, password);
	}
	
	
}
