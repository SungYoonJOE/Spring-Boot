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
	
	//@Autowired
	//HttpSession session;
	
	public void update(String freeid, String title, String content, String writer) {
		Long freeId = Long.parseLong(freeid);
		Freeboard freeboard = freeboardRepository.findByFreeid(freeId);
		
		freeboard.setTitle(title);
		freeboard.setContent(content);
		freeboard.setWriter(writer);
		
		freeboardRepository.save(freeboard);
		//session.setAttribute("freeboard", freeboard);
	}
}
