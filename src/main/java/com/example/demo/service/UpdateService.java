package com.example.demo.service;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UpdateService {
	
	@Autowired
	public UsersRepository userRepository;
	
	@Autowired
	public UserPasswordHashClass userPasswordHashClass;
	
	@Autowired
	HttpSession session;
	
	public String updateUser(String userId, String userPw, String userName) {
		
		if(userId.equals("")|| userPw.equals("")||userName.equals("")) { //비어있는 경우
			return "updateInfo"; //그대로 회원정보수정 페이지
		}
		
		//Users user = 
		
		//Users users = new Users();
		//Users user = userRepository.findByUseridAndPassword(userId, userPw);
		//Users user = userRepository.findByUseridAndPassword(userId, userPw);
		Users user = (Users)session.getAttribute("loginUser");
		System.out.println("updateService1 = "+user);		
		
		String hashedPW = userPasswordHashClass.getSHA256(userPw);

		user.setUserid(userId);
		user.setPassword(hashedPW);
		user.setUsername(userName);
		System.out.println("updateService2 = "+user);
		
		userRepository.save(user);
		session.setAttribute("loginUser", user);
		
		System.out.println("정보수정 후 loginUser="+session.getAttribute("loginUser"));
		
		
		return "index";
		
	}
	
}