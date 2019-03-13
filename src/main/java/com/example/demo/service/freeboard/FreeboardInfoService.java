package com.example.demo.service.freeboard;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mappers.FreeboardMapper;
import com.example.demo.model.Freeboard;
import com.example.demo.repository.FreeboardRepository;

@Service
public class FreeboardInfoService {
	
	@Autowired
	private FreeboardRepository freeboardRepository;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	FreeboardMapper freeboardMapper;
	
	
	public String getFreeboardById(String strfreeid) {
		Long freeId = Long.parseLong(strfreeid);
		Freeboard freeboard = freeboardMapper.selectFreeboardById(freeId);
		// 없는 게시글에 접근할 경우
		if (freeboard == null) {
			return "freeboard";
		}

		// 지금 보고 있는 글 정보를 저장
		session.setAttribute("freeboard", freeboard);
		System.out.println("글 상세조회에서 session에 freeboard저장" + session.getAttribute("freeboard"));
		return "freeboardInfo";
	}

	/*
	public Freeboard getFreeboardById(Long freeid) {
		return freeboardMapper.selectFreeboardById(freeid);
	}
	 */
	public List<Freeboard> getAllFreeboard() {
		return freeboardMapper.selectAllFreeboard();
	}

	public void addFreeboard(Freeboard freeboard) {
		freeboardMapper.insertFreeboard(freeboard);
	}
	 
	/*
	public String getFreeboardPost(String stringFreeId) {
		Long freeId = Long.parseLong(stringFreeId);
		Freeboard freeboard = freeboardRepository.findById(freeId).get();
		
		
		//Freeboard freeboard = freeboardRepository.findByFreeid(freeId);
		
		//없는 게시글에 접근할 경우
		if(freeboard == null) {
			return "freeboard";
		}
		
		//지금 보고 있는 글 정보를 저장 
		session.setAttribute("freeboard", freeboard);
		System.out.println("글 상세조회에서 session에 freeboard저장"+session.getAttribute("freeboard"));
		return "freeboardInfo";
	}
	*/
}
