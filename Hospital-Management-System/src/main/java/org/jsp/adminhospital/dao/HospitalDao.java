package org.jsp.adminhospital.dao;

import java.util.Optional;

import org.jsp.adminhospital.dto.Hospital;
import org.jsp.adminhospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepository repository;
	
	public Hospital save (Hospital h) {
		return repository.save(h);
	}
	
	public Hospital updateAdmin(Hospital h) {
		return repository.save(h);
	}
	
	public Optional<Hospital> findById(int id) {
		return repository.findById(id);
	}
	
	public Optional<Hospital> verify(long phone, String password) {
		return repository.verify(phone, password);
	}
	
	public Optional<Hospital> verify(String email, String password) {
		return repository.verify(email, password);
	}

}
