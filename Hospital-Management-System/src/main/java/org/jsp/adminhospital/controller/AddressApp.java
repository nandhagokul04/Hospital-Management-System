package org.jsp.adminhospital.controller;

import org.jsp.adminhospital.dto.Address;
import org.jsp.adminhospital.dto.ResponseStructure;
import org.jsp.adminhospital.service.AddressService;
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
@RequestMapping(value ="/address")
public class AddressApp {
	
	@Autowired	
	private AddressService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> save(@RequestBody Address h){
		return service.saveHospital(h);	
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> update (@RequestBody Address h){
		return service.updateAdmin(h);	
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Address>> findbyid (@PathVariable int id){
		return service.findById(id);	
	}

}
