package org.jsp.adminhospital.dao;

import java.util.Optional;

import org.jsp.adminhospital.dto.Admin;
import org.jsp.adminhospital.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepository repository;
	
	public Admin saveAdmin(Admin a) {
		return repository.save(a);
	}
	
	public Admin updateAdmin(Admin a) {
		return repository.save(a);
	}
	
	public Optional<Admin> findById(int id) {
		return repository.findById(id);
	}
	
	public Optional<Admin> verify(long phone, String password) {
		return repository.verify(phone, password);
	}
	
	public Optional<Admin> verify(String email, String password) {
		return repository.verify(email, password);
	}
}