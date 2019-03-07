package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Freeboard;
import com.example.demo.service.freeboard.FreeboardListService;



@Controller
public class FreeboardController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private FreeboardListService freeboardListService;
	
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
}
