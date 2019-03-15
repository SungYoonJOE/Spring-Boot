package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mappers.FreeboardMapper;
import com.example.demo.model.Freeboard;
import com.example.demo.repository.FreeboardRepository;
import com.example.demo.service.freeboard.FreeboardDeleteService;
import com.example.demo.service.freeboard.FreeboardInfoService;
import com.example.demo.service.freeboard.FreeboardListService;
import com.example.demo.service.freeboard.FreeboardUpdateService;
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
	
	@Autowired
	private FreeboardUpdateService freeboardUpdateService;
	
	@Autowired
	private FreeboardDeleteService freeboardDeleteService;
	
	@Autowired
	private FreeboardRepository freeboardRepository;
	
	@Autowired
	private FreeboardMapper freeboardMapper;
	
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

	//게시글 상세조회 요청 page 반환
	@GetMapping("/freeBoardInfo")
	public String getPost(@RequestParam(value = "freeId") String freeId, @Autowired HttpSession session) {

		Long freeid = Long.parseLong(freeId);
		Freeboard freeboard = freeboardMapper.selectFreeboardById(freeid);
			
		if(freeboard == null ) {
			String page = "freeboard";
		}
		session.setAttribute("freeboard", freeboard);
		String page = "freeboardInfo";
		
		return page;
	}

	//게시글 상세조회 요청 데이터 반환
	@RequestMapping(value="/api/freeboardInfo", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody JSONObject getFreeboard(@RequestParam(value = "freeId") String freeId) {
		Long freeid = Long.parseLong(freeId);
		//Freeboard freeboard = freeboardMapper.selectFreeboardById(freeid);
		JSONObject jsonBoard = new JSONObject();
		jsonBoard = freeboardInfoService.getFreeboardById(freeid);
		System.out.println("여기까지?");

		if(jsonBoard == null ) {
			//null일 경우 
			System.out.println("jsonBoard가 null");
		}
			
		//freeboard를 JSON으로 프론트에 주기
		
		return jsonBoard;
	}
	
	//게시글 수정요청이 들어올 때
	@PostMapping("/freeboardUpdateRequest")
	public String updateFreeboardInfo(@RequestParam Map<String, String> paramMap, @Autowired HttpSession session) {
		String freeId = paramMap.get("freeid");
		String title = paramMap.get("title");
		String content = paramMap.get("content");
		String writer = paramMap.get("writer");
		
		freeboardUpdateService.update(freeId, title, content, writer);
		
		Long longFreeid = Long.parseLong(freeId);
		
		Freeboard freeboard = freeboardRepository.findByFreeid(longFreeid);
		session.setAttribute("freeboard", freeboard);
		 
		return "redirect:/freeboard";
	}
		
	//게시글 삭제 요청이 들어올 때
	@PostMapping("/deleteFreeboardRequest")
	public String deleteFreeboard(@RequestParam Map<String, String> paramMap) {

		String freeId = paramMap.get("freeid");
		
		freeboardDeleteService.deleteFreeboard(freeId);
		
		return "redirect:/freeboard";
	}
}
	
