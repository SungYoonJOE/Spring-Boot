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
	
	@Autowired
	HttpSession session;
	
	public String deleteUser(String userId) {
		
		Users user = (Users)session.getAttribute("loginUser");
		
		userRepository.delete(user);
		//userRepository.deleteByUserid(userId);
		System.out.println("탈퇴성공");
		session.invalidate();
		System.out.println("session이 널값어야함=");
		return "index";
	}
}
