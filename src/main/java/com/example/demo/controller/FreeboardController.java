package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.freeboard.FreeboardInfoService;
import com.example.demo.service.freeboard.FreeboardListService;
import com.example.demo.service.freeboard.FreeboardWriteService;



@Controller
public class FreeboardController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private FreeboardListService freeboardListService;
	
	@Autowired
	private FreeboardWriteService freeboardWriteService;
	
	@Autowired
	private FreeboardInfoService freeboardInfoService;
	
	private int returnIntValue(String stringToInt){
		return Integer.parseInt(stringToInt);
	};
	
	//프론트에서 몇 페이지인지 보내줌. 보내준 값이 없을 경우 default는 1페이지
	@GetMapping("/freeboard")
	public String fboard(@RequestParam(value="pageNum", defaultValue = "1")String pageNum) {
		//List<Freeboard> freeboardList = freeboardListService.freeboardList(returnIntValue(pageNum));
		String page = freeboardListService.freeboardList(returnIntValue(pageNum));
		/*
		if(freeboardList == null) {
			return "freeboard";
		}
		session.setAttribute("boardList", freeboardList);
		*/
		//return "freeboard";
		return page;
	}
	
	@PostMapping("/freeboardWriteRequest")
	public String freeboardWriteRequest(@RequestParam Map<String, String> paramMap) {
		String title = paramMap.get("title");
		String content = paramMap.get("content");
		String writer = paramMap.get("writer");
		
		System.out.println("title in html>>"+title);
		System.out.println("content in html>>"+ content);
		System.out.println("writer in html>>"+ writer);
		
		freeboardWriteService.write(title, content, writer);
		
		return "redirect:/freeboard";//redirect 다음에 있는 freeboard를 찾아가게 됨
	}
	
	//게시글 상세조회 요청이 들어올 때
	@GetMapping("/freeBoardInfo")
	public String getPost(@RequestParam(value = "freeId") String freeId) {
		String page = freeboardInfoService.getFreeboardPost(freeId);
		return page;
	}
}
	
