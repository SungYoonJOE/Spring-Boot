package com.example.demo.service.freeboard;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
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
	private FreeboardMapper freeboardMapper;
	
	public JSONObject getFreeboardById(Long freeid) {
		//Long freeId = Long.parseLong(strfreeid);
		Freeboard freeboard = freeboardMapper.selectFreeboardById(freeid);
		// 없는 게시글에 접근할 경우
		if(freeboard == null) {
			//return "";
		}

		JSONObject obj = new JSONObject();
		
		obj.put("freeid", freeboard.getFreeid());
		obj.put("title", freeboard.getTitle());
		obj.put("content", freeboard.getContent());
		obj.put("writer", freeboard.getWriter());
		
		return obj;
	}
	
	
	/*
	 * public String getFreeboardById(Long freeid) { //Long freeId =
	 * Long.parseLong(strfreeid); Freeboard freeboard =
	 * freeboardMapper.selectFreeboardById(freeid); // 없는 게시글에 접근할 경우 if(freeboard
	 * == null) { return "freeboard"; }
	 * 
	 * JSONObject obj = new JSONObject();
	 * 
	 * obj.put("freeid", freeboard.getFreeid()); obj.put("title",
	 * freeboard.getTitle()); obj.put("content", freeboard.getContent());
	 * obj.put("writer", freeboard.getWriter());
	 * 
	 * // 지금 보고 있는 글 정보를 저장 //session.setAttribute("freeboard", freeboard);
	 * //System.out.println("글 상세조회에서 session에 freeboard저장" +
	 * session.getAttribute("freeboard")); //return "freeboardInfo"; }
	 */
	
	
	
/*
	public List<Freeboard> getAllFreeboard() {
		return freeboardMapper.selectAllFreeboard();
	}

	public void addFreeboard(Freeboard freeboard) {
		freeboardMapper.insertFreeboard(freeboard);
	}
*/
	 
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
