package org.jsp.adminhospital.service;

import java.util.Optional;

import org.jsp.adminhospital.dao.BranchDao;
import org.jsp.adminhospital.dto.Branch;
import org.jsp.adminhospital.dto.ResponseStructure;
import org.jsp.adminhospital.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class BranchService {
	@Autowired
	private BranchDao dao;

	public ResponseEntity<ResponseStructure<Branch>> saveHospital(Branch b) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		structure.setMessage("Hospital added successfully!");
		structure.setData(dao.save(b));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> update(Branch b) {
		Optional<Branch> hospital = dao.findById(b.getId());
		if (hospital.isPresent()) {
			Branch hos = new Branch();
			hos.setId(b.getId());
			hos.setName(b.getName());
			hos.setEmail(b.getEmail());
			hos.setPhone(b.getPhone());
			ResponseStructure<Branch> structure = new ResponseStructure<>();
			structure.setMessage("Hospital added successfully!");
			structure.setData(dao.save(hos));
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException("Inavlid id entered!");
	}

	public ResponseEntity<ResponseStructure<Branch>> findById(int id) {
		Optional<Branch> branch = dao.findById(id);
		if (branch.isPresent()) {
			ResponseStructure<Branch> structure = new ResponseStructure<>();
			structure.setMessage("Found!");
			structure.setData(branch.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException("Inavlid id entered!");
	}
}
