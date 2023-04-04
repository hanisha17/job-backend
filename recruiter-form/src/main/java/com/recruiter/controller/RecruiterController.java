package com.recruiter.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recruiter.model.Recruiter;
import com.recruiter.model.Skills;
import com.recruiter.model.Status;
import com.recruiter.repository.RecruiterRepo;
import com.recruiter.repository.SkillsRepo;




@Transactional
@RestController

//@CrossOrigin(origins={"http://localhost:4200"})
@RequestMapping("/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterRepo repo;

    @Autowired
    private SkillsRepo skillrepo;

//    @PostMapping("/save")
//    public Person savePerson(@RequestBody RegisterRequest request) {
//        return personRepository.save(request.getPerson());
//    }

    @PostMapping("/recruiter-login")
    public Recruiter registerUser(@RequestBody Recruiter request) throws Exception{
    	System.out.println("Printing the input");
    	System.out.println(request); 
         return repo.save(request);
    }
    
    
    
    @DeleteMapping("/delete/{id}")
    public void deleteRecruiterByName(@PathVariable ("id") Long id) {
    	repo.deleteById(id);
    }


    @GetMapping("/sign-in/home")
    public List<Recruiter> findAllRegisters(){
        return repo.findAll();
    }
    
    @GetMapping("/skills/{skill}")
    
    public List<Recruiter> getSkill(@PathVariable(name = "skill")String skill) {
    	System.out.println(skill);
    	List<Skills> skill1 = skillrepo.findBySkill(skill);
//    	List<Skills> skills = new ArrayList<>();
//    	skills.add(skill1);
    	System.out.println(skill1);
    	return repo.findByDropdownIn(skill1);
    }
    	
    @GetMapping("/sign-in/home/{id}")
    public Recruiter getRecruiterById(@PathVariable("id") Long id ) {
        System.out.println(id);
        return repo.findAllById(id);
   }

    
    @PutMapping("/changestatus")
    public Recruiter changeStatus(@RequestBody Recruiter request ) {
        Recruiter r=repo.findAllById(request.getId());
        r.setStatus(Status.Approved);
        repo.save(r);
        return r;
        
        		
//        r.setStatus(Status.approved);
//        repo.save(r);
//        return r;

    }
    
    @GetMapping("/getallstatus/{status}")
    public List<Recruiter> getAllStatus(@PathVariable("status") Status status ){
    	return repo.findByStatus(status);
    }

}