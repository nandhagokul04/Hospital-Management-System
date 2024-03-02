package org.jsp.adminhospital.controller;

import org.jsp.adminhospital.dto.Branch;
import org.jsp.adminhospital.dto.ResponseStructure;
import org.jsp.adminhospital.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/branch")
public class BranchApp {
	@Autowired	
	private BranchService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> save(@RequestBody Branch h){
		return service.saveHospital(h);	
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Branch>> update (@RequestBody Branch h){
		return service.update(h);	
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Branch>> findbyid (@PathVariable int id){
		return service.findById(id);	
	}

}
