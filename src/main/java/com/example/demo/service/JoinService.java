package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class JoinService {
	
	@Autowired
	public UsersRepository userRepository;
	
	@Autowired
	private UserPasswordHashClass userPasswordHashClass;
	
	/*
	public void joinUser(HttpServletRequest request, UserRepository userRepository) {
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String userName = request.getParameter("user_name");
		
		Users users = new Users();
		users.setUser_id(userId);
		users.setUser_pw(userPw);
		users.setUser_name(userName);
		
		userRepository.save(users);//데이터베이스에 저장하는 함수 save()
	}
	*/
	
	public String joinUser(String userId, String userPw, String userName) {
		
		if(userId.equals("")|| userPw.equals("")||userName.equals("")) { //비어있는 경우
			return "join";
		}
		
		Users users = new Users();
		//users.setUser_id(userId);

		String hashedPW = userPasswordHashClass.getSHA256(userPw);
		
		//users.setUser_pw(hashedPW);
		users.setUserid(userId);
		users.setPassword(hashedPW);
		users.setUsername(userName);
		       
		userRepository.save(users);//데이터베이스에 저장하는 함수 save()
		return "index";
	}

}
