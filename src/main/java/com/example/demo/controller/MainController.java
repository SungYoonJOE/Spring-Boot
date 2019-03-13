package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	//메인컨트롤러에서는 페이지를 넘겨주는 역할만 함
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/joinPage")
	public String joinPage() {
		return "join";
	}
	
	@GetMapping("/loginPage")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/logoutPage")
	public String logout() {
		session.invalidate();
		System.out.println("로그아웃 확인>>"+session.getAttribute("loginUser"));
		return "index";
	}
	
	@GetMapping("/updateInfoPage")
	public String updateInfo() {
		return "updateInfo";
	}
	
	@GetMapping("/freeboardWritePage")
	public String freeboardWritePage() {
		return "freeboardWrite";
	}
	
	@GetMapping("/freeboardUpdatePage")
	public String freeboardUpdatePage() {
		return "freeboardUpdate";
	}
	
}
