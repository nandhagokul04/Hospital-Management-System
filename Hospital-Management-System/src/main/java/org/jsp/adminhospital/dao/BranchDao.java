package org.jsp.adminhospital.dao;

import java.util.Optional;

import org.jsp.adminhospital.dto.Branch;
import org.jsp.adminhospital.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepository repository;
	
	public Branch save (Branch b) {
		return repository.save(b);
	}
	
	public Branch updateAdmin(Branch b) {
		return repository.save(b);
	}
	
	public Optional<Branch> findById(int id) {
		return repository.findById(id);
	}
	

}
