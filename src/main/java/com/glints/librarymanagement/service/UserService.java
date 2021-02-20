package com.glints.librarymanagement.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.glints.librarymanagement.model.Employee;
import com.glints.librarymanagement.repository.EmployeeRepo;

@Service
public class UserService {
	EmployeeRepo repository;
//	PasswordEncoder passwordEncoder;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public UserService(EmployeeRepo repository) {
		this.repository = repository;
		this.bCryptPasswordEncoder = new BCryptPasswordEncoder();	
	}
	public Employee save(Employee employee) {
		String encodedPassword = this.bCryptPasswordEncoder.encode(employee.getPassword());
		employee.setPassword(encodedPassword);
		return this.repository.save(employee);
	}

}
