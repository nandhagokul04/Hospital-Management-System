package org.jsp.adminhospital.controller;

import org.jsp.adminhospital.dto.Admin;
import org.jsp.adminhospital.dto.ResponseStructure;
import org.jsp.adminhospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminApp {

	@Autowired
	private AdminService service;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin a) {
		return service.saveAdmin(a);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin a) {
		return service.updateAdmin(a);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findById(@PathVariable(name = "id") int id) {
		return service.findById(id);
	}

	@PostMapping("/verify-by-phone")
	public ResponseEntity<ResponseStructure<Admin>> verifyByPhone(@RequestParam long phone,
			@RequestParam String password) {
		return service.verifyByPhone(phone, password);
	}

	@PostMapping("/verify-by-email")
	public ResponseEntity<ResponseStructure<Admin>> verifyByEmail(@RequestParam String email,
			@RequestParam String password) {
		return service.verifyByEmail(email, password);
	}
}
