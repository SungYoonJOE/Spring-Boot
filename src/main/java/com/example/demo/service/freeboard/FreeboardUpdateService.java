package com.example.demo.service.freeboard;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Freeboard;
import com.example.demo.repository.FreeboardRepository;

@Service
public class FreeboardUpdateService {

	@Autowired
	FreeboardRepository freeboardRepository;
	
	@Autowired
	HttpSession session;
	
	public void update(String title, String content, String writer) {
		//Freeboard freeboard = freeboardRepository.findByTitleAndWriter(title, writer);
		
		//글 상세조회(FreeboardInfoService)에서 session에 저장한 freeboard
		Freeboard freeboard = (Freeboard)session.getAttribute("freeboard");
		
		freeboard.setTitle(title);
		freeboard.setContent(content);
		freeboard.setWriter(writer);
		
		
		freeboardRepository.save(freeboard);
		session.setAttribute("freeboard", freeboard);
	}
	
}
