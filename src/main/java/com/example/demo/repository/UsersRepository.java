package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Users;

//Repository는 myBatis mapper interface와 같은 역할
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	//함수명으로 쿼리형태로 실행될 수 있게 해줌
		//public Users findByUserIdAndUserPw(String user_id, String user_pw);
		
		Users findByUseridAndPassword(String userid, String userPw);
		
		
		//List<Users> findByUseridAndPassword(String userId, String userPw);


}
