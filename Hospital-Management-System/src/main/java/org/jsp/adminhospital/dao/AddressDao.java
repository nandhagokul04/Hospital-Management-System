package org.jsp.adminhospital.dao;

import org.jsp.adminhospital.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepository repository;
	
	
}
