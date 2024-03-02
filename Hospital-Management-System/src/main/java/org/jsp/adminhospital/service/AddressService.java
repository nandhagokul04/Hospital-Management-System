package org.jsp.adminhospital.service;

import java.util.Optional;

import org.jsp.adminhospital.dao.AddressDao;
import org.jsp.adminhospital.dto.Address;
import org.jsp.adminhospital.dto.ResponseStructure;
import org.jsp.adminhospital.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;

	public ResponseEntity<ResponseStructure<Address>> saveHospital(Address b) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		structure.setMessage("Hospital added successfully!");
		structure.setData(dao.save(b));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAdmin(Address b) {
		Optional<Address> hospital = dao.findById(b.getId());
		if (hospital.isPresent()) {
			Address hos = new Address();
			hos.setId(b.getId());
			hos.setBuilding_name(b.getBuilding_name());
			hos.setCity(b.getCity());
			hos.setCountry(b.getCountry());
			hos.setLandmark(b.getLandmark());
			hos.setPincode(b.getPincode());
			hos.setState(b.getState());
			hos.setStreet(b.getStreet());
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setMessage("Hospital added successfully!");
			structure.setData(dao.save(hos));
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException("Inavlid id entered!");
	}

	public ResponseEntity<ResponseStructure<Address>> findById(int id) {
		Optional<Address> branch = dao.findById(id);
		if (branch.isPresent()) {
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setMessage("Found!");
			structure.setData(branch.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException("Inavlid id entered!");
	}
}
