package com.example.demo.service.freeboard;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Freeboard;
import com.example.demo.repository.FreeboardRepository;

@Service
public class FreeboardDeleteService {
	
	@Autowired
	public FreeboardRepository freeboardRepository;

	
	public void deleteFreeboard(String freeid) {
		Long freeId = Long.parseLong(freeid);
		Freeboard freeboard = freeboardRepository.findByFreeid(freeId);
		//System.out.println("freeid로 찾기"+freeboardRepository.findByFreeid(freeId));
		freeboardRepository.delete(freeboard);
		//System.out.println("글 삭제 성공");	
	}

}
