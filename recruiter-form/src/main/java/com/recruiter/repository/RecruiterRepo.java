package com.recruiter.repository;

import java.util.List;
import com.recruiter.model.Recruiter;
import com.recruiter.model.Skills;
import com.recruiter.model.Status;

import org.springframework.data.jpa.repository.JpaRepository;



public interface RecruiterRepo extends JpaRepository<Recruiter, Long> {
//	public void deleteByCompanyName(String companyName);
	
//	@Query(value="select r.*, s.skill from recruiter r join skills s on r.id = s.s_id;",nativeQuery = true)
	public List<Recruiter> findByDropdownIn(List<Skills> skill);
	
	public Recruiter findAllById(Long id);
		
	public List<Recruiter> findByStatus(Status status);
}
