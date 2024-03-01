package org.jsp.adminhospital.service;

import java.util.Optional;

import org.jsp.adminhospital.dao.AdminDao;
import org.jsp.adminhospital.dto.Admin;
import org.jsp.adminhospital.dto.ResponseStructure;
import org.jsp.adminhospital.exception.IdNotFoundException;
import org.jsp.adminhospital.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	public AdminDao adao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin a) {
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		structure.setMessage("Admin saved successfully....");
		structure.setData(adao.saveAdmin(a));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin a){
		Optional<Admin> admin=adao.findById(a.getId());
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		if(admin.isPresent()) {
			Admin ad=admin.get();
			ad.setName(a.getName());
			ad.setPhone(a.getPhone());
			ad.setEmail(a.getEmail());
			ad.setPassword(a.getPassword());
			structure.setMessage("Admin updated successfully......");
			structure.setData(adao.saveAdmin(a));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> findById(int id){
		Optional<Admin> admin=adao.findById(id);
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		if(admin.isPresent()) {
			structure.setMessage("Admin found...");
			structure.setData(admin.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> verifyByPhone(long phone, String password){
		Optional<Admin> admin=adao.verify(phone, password);
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		if(admin.isPresent()) {
			structure.setMessage("Admin found...");
			structure.setData(admin.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("Invalid phone & password");
	}
	
	public ResponseEntity<ResponseStructure<Admin>> verifyByEmail(String email, String password){
		Optional<Admin> admin=adao.verify(email, password);
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		if(admin.isPresent()) {
			structure.setMessage("Admin found...");
			structure.setData(admin.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("Invalid phone & password");
	}
}
