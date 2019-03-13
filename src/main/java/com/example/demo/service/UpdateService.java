package com.example.demo.service;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Freeboard;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UpdateService {
	
	@Autowired
	public UsersRepository userRepository;
	
	@Autowired
	public UserPasswordHashClass userPasswordHashClass;
	
	public String updateUser(String userId, String userPw, String userName) {
		if(userPw.equals("")||userName.equals("")) { //비어있는 경우
			return "updateInfo"; //그대로 회원정보수정 페이지
		}
		
		Users user = userRepository.findByUserid(userId);
		
		System.out.println("updateUserService1 "+userRepository.findByUserid(userId));
		
		System.out.println("updateService2 = "+user);		
		
		String hashedPW = userPasswordHashClass.getSHA256(userPw);

		user.setPassword(hashedPW);
		user.setUsername(userName);
		System.out.println("updateService2 = "+user);
		
		userRepository.save(user);
		

		
		return "index";
		
	}
}