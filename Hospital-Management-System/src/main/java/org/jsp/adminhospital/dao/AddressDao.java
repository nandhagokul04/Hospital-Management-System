package org.jsp.adminhospital.dao;

import java.util.Optional;

import org.jsp.adminhospital.dto.Address;
import org.jsp.adminhospital.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AddressDao{
	@Autowired
	private AddressRepository repository;
	
	public Address save (Address h) {
		return repository.save(h);
	}
	
	public Address updateAdmin(Address h) {
		return repository.save(h);
	}
	
	public Optional<Address> findById(int id) {
		return repository.findById(id);
	}
}


