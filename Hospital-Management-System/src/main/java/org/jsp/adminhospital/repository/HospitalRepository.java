package org.jsp.adminhospital.repository;

import java.util.Optional;

import org.jsp.adminhospital.dto.Admin;
import org.jsp.adminhospital.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	
	@Query("select h from Hospital h where h.phone=?1 and h,password=?2")
	public Optional<Hospital> verify(long phone, String password);
	
	@Query("select h from Hospital h where h.email=?1 and h,password=?2")
	public Optional<Hospital> verify(String email, String password);

}
