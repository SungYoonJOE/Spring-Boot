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
	
}
