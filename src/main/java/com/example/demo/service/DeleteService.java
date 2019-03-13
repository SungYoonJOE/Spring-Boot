package com.example.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class DeleteService {
	
	@Autowired
	public UsersRepository userRepository;
	
	
	public String deleteUser(String userId) {
		
		
		Users user = userRepository.findByUserid(userId);
		
		System.out.println("deleteUserService1 "+userRepository.findByUserid(userId));
		
		System.out.println("deleteUserService2 = "+ user);
		
		userRepository.delete(user);

		System.out.println("탈퇴성공");

		return "index";
	}
}

