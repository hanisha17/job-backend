package com.recruiter.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recruiter.model.Skills;



public interface SkillsRepo extends JpaRepository<Skills, Long> {
	@Query("from Skills where skill in :skill")
	public List<Skills> findAllBySkill(String skill);
	
	public List<Skills> findBySkill(String skill);
}
