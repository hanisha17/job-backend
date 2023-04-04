package com.jwt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.dao.RoleDao;
import com.jwt.dao.UserDao;
import com.jwt.model.Role;
import com.jwt.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void initRoleAndUser() {
		
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		roleDao.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("User");
		roleDao.save(userRole);
		
		User adminUser = new User();
		adminUser.setUserName("Admin");
		adminUser.setPassword(getEncodedPassword("Admin123"));
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);
		
		
	}
	
	public User registerNewUser(User user) {
		Role role = roleDao.findById("User").get();
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRole(userRoles);
		user.setPassword(getEncodedPassword(user.getPassword()));
		
		return userDao.save(user);
		
	}
	
	 public String getEncodedPassword(String password) {
	        return passwordEncoder.encode(password);
	}
	
	
	
}
