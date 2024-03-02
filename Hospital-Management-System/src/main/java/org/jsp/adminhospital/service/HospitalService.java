package org.jsp.adminhospital.service;

import java.util.Optional;

import org.jsp.adminhospital.dao.HospitalDao;
import org.jsp.adminhospital.dto.Admin;
import org.jsp.adminhospital.dto.Hospital;
import org.jsp.adminhospital.dto.ResponseStructure;
import org.jsp.adminhospital.exception.IdNotFoundException;
import org.jsp.adminhospital.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HospitalService {
	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital h) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		structure.setMessage("Hospital added successfully!");
		structure.setData(dao.save(h));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateAdmin(Hospital h) {
		Optional<Hospital> hospital = dao.findById(h.getId());
		if (hospital.isPresent()) {
			Hospital hos = new Hospital();
			hos.setId(h.getId());
			hos.setName(h.getName());
			hos.setFounder(h.getFounder());
			hos.setGst(h.getGst());
			hos.setYear_of_establishment(h.getYear_of_establishment());
			ResponseStructure<Hospital> structure = new ResponseStructure<>();
			structure.setMessage("Hospital added successfully!");
			structure.setData(dao.save(hos));
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException("Inavlid id entered!");
	}

	public ResponseEntity<ResponseStructure<Hospital>> findById(int id) {
		Optional<Hospital> hospital = dao.findById(id);
		if (hospital.isPresent()) {
			ResponseStructure<Hospital> structure = new ResponseStructure<>();
			structure.setMessage("Hospital added successfully!");
			structure.setData(hospital.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException("Inavlid id entered!");
	}

	public ResponseEntity<ResponseStructure<Hospital>> verify(long phone, String password){
		Optional<Hospital> hospital=dao.verify(phone, password);
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		if(hospital.isPresent()) {
			structure.setMessage("Hospital found...");
			structure.setData(hospital.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("Invalid phone & password");
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> verify(String email, String password){
		Optional<Hospital> hospital=dao.verify(email, password);
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		if(hospital.isPresent()) {
			structure.setMessage("Hospital found...");
			structure.setData(hospital.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("Invalid phone & password");
	}

}
