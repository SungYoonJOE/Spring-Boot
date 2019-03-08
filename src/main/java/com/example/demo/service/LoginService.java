package com.example.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class LoginService {
	
	//사용자가 로그인할 때 입력한 비밀번호를 똑같은 방식으로 해싱해서 디비의 sh256으로 저장된 암호와 비교
	@Autowired
	UserPasswordHashClass userPasswordHashClass;
	
	@Autowired
	private UsersRepository userRepository;
	
	//사용자 정보를 세션에 저장
	@Autowired
	HttpSession session;
	
	
	public String login(String userId, String userPw) {
		if(userId.equals("")|| userPw.equals("")) {
			return "login";
		}
		
		String hashedPW = userPasswordHashClass.getSHA256(userPw);
		System.out.println("login hashedPW>>>>"+hashedPW);
		Users user = userRepository.findByUseridAndPassword(userId, hashedPW);
		System.out.println("로그인 성공");
		
		
		if(user == null) {
			return "login";
		}
		//session.loginUser.getUserName()
		session.setAttribute("loginUser", user);
		System.out.println("session user= "+session.getAttribute("loginUser"));
		//System.out.println("session userName>> "+session.getAttribute("loginUser").);
		//System.out.println("User의 이름만>>"+session.getAttribute("loginUser").getUsername());
		
		return "index";
	}

}
