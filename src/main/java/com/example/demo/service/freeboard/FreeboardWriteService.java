package com.example.demo.service.freeboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Freeboard;
import com.example.demo.repository.FreeboardRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor //자동생성자  
@Service
public class FreeboardWriteService {

	@Autowired
	FreeboardRepository freeboardRepository;
	
	public void write(String title, String content, String writer) {
		Freeboard freeboard = new Freeboard();
		freeboard.setTitle(title);
		freeboard.setContent(content);
		freeboard.setWriter(writer);	
		
		//System.out.println("게시글 확인>>"+freeboard);
		//System.out.println("게시글 작성자>>"+freeboard.getWriter());
		//System.out.println(freeboard);
		
		freeboardRepository.save(freeboard);
		
	}
}

