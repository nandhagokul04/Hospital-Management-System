package org.jsp.adminhospital.dao;

import java.util.Optional;

import org.jsp.adminhospital.dto.Address;
import org.jsp.adminhospital.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AddressDao
{
	@Autowired
	private AddressRepository addressRepository;
	
	public Address saveAddress(Address a)
	{
		return addressRepository.save(a);
	}
	
	public Address updaAddress(Address a)
	{
		return addressRepository.save(a);
	}
	public Optional<Address> findById(int id)
	{
		return addressRepository.findById(id);
	}
}
