package com.example.demo.controller;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.DeleteService;
import com.example.demo.service.JoinService;
import com.example.demo.service.LoginService;
import com.example.demo.service.UpdateService;


@Controller
public class UsersController {
//서비스 클래스를 호출하는 컨트롤러
	
	//객체 주입
//	@Autowired
//	private UserRepository userRepository;//보통 여기다 안 하고 Service 클래스에 함
	
	@Autowired
	private JoinService joinService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UpdateService updateUserService;
	
	@Autowired
	private DeleteService deleteUserService;
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private HttpSession session;
	
	//가입요청을 받을 때	
	@PostMapping("/joinRequest")
	@ResponseBody//html이 아니라 json형식으로 반환
	public String joinRequest(@RequestParam Map<String, String> paramMap) {
		System.out.println("제대로 요청됐는지 확인");
		String userId = paramMap.get("user_id");
		String userPw = paramMap.get("user_pw");
		String userName = paramMap.get("user_name");
		
		String page = joinService.joinUser(userId, userPw, userName);
		System.out.println("성공시 page값=index >>"+page);
		return page;
	}

	//로그인 요청 받을 때
	@PostMapping("/loginRequest") //비밀번호 암호화, 복구화 sha256사용 (해싱)
	@ResponseBody
	public String loginRequest(@RequestParam Map<String, String> paramMap) {
		String userId = paramMap.get("user_id");
		String userPw = paramMap.get("user_pw");
		
		//page를 return하게 함. index/join/login인지. login이 잘 되면 main으로 이동하게 함. login이 안 되면 계속 login에 머무르게함 
		String page = loginService.login(userId, userPw); 
		System.out.println("성공시 page값=index >>"+page);
		return page;
	}
	
	  //회원 정보 수정 요청  
	 @PostMapping("/updateInfoRequest") 
	 public String updateInfoRequest(@RequestParam Map<String, String> paramMap, @Autowired HttpSession session) { 
	 	//String pid = paramMap.get("pid"); 
	 	String userPw = paramMap.get("user_pw"); 
	 	String userName = paramMap.get("user_name");
	 	String userId = paramMap.get("user_id");
	
	 	
	 	String page = updateUserService.updateUser(userId, userPw, userName);
	 	
	 	Users user = userRepository.findByUserid(userId);
	 	
	 	session.setAttribute("loginUser", user);
	 	System.out.println("session에 새로 저장 = "+session.getAttribute("loginUser"));
	 	System.out.println("수정 성공시 page 값 ="+page); 
	 	return page;
	 }
	 
	//회원탈퇴 요청
	@PostMapping("/deleteRequest")
	public String deleteRequest(@RequestParam Map<String, String> paramMap, @Autowired HttpSession session) {
		
		String userId = paramMap.get("user_id");
		
		System.out.println("userId in UserController = "+paramMap.get("user_id"));
		
		String page = deleteUserService.deleteUser(userId);
		session.invalidate();
		return page;
	}
}
