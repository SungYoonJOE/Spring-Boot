package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UpdateService {
	
	/*	
		@Autowired
		public UsersRepository userRepository;
		
		@Autowired
		public UserPasswordHashClass userPasswordHashClass;
		
		
		public String updateUser(String userId, String userPw, String userName) {
			if(userId.equals("")|| userPw.equals("")||userName.equals("")) { //비어있는 경우
				System.out.println("비어있는 칸이 없어야 함");
				return "update";
			}
			
			Users users = new Users();
			users.setUserid(userId);
			String hashedPW = userPasswordHashClass.getSHA256(userPw);
			users.setPassword(hashedPW);
			users.setUsername(userName);
			
			userRepository.save(users);
			System.out.println("수정완료");
			return "index";
		}
	
	}
	*/
}