package com.example.demo.service.freeboard;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Freeboard;
import com.example.demo.repository.FreeboardRepository;


@Service
public class FreeboardListService {
	
	//만들어 놓은 repository 호출해서 사용
	@Autowired		
	private FreeboardRepository freeboardRepository;
	@Autowired
	private HttpSession session;
	
	//public List<Freeboard> freeboardList(int pageNum){
	public String freeboardList(int pageNum) {
		
		//1페이지에 10개 freeid를 기준으로 내림차순 정렬(최신순)
		PageRequest pageRequest = PageRequest.of(pageNum-1, 10, Sort.Direction.DESC, "bid");
		
		//페이지를 return함
		Page<Freeboard> freeboardPage = freeboardRepository.findAll(pageRequest);
		
		//게시글이 없을 때 
		if(freeboardPage.getSize() ==0) {
			//return new ArrayList<Freeboard>();//값은 있지만 크기가 0인 리스트를 반환
			//new ArrayList<Freeboard>();
			session.setAttribute("boardList", new ArrayList<Freeboard>());
			//return " ";
			return "freeboard";
		}
		
		List<Freeboard> freeboardList = freeboardPage.getContent();
		session.setAttribute("boardList", freeboardList);
		
		
		//페이지가 2, 3, 4 만들 수 있게 해놓은 페이지 메이커는 다른 강좌에 있음 참고. 
		//return freeboardList;
		return "freeboard";
	}
}
