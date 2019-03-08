package com.example.demo.service.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Freeboard;
import com.example.demo.pagemaker.PageMaker;

@Service
public class PageMakerService {

	public PageMaker generatePageMaker(int pageNum, int contentNum, JpaRepository<Freeboard, Long> repository) {
		PageMaker pageMaker = new PageMaker();
		
		int totalCount = (int)repository.count();
		pageMaker.setTotalCount(totalCount); //전체 게시글 수 지정
		pageMaker.setPageNum(pageNum-1); //현재 페이지를 페이지 객체에 저장. -1을 해야 쿼리에서 사용 가능
		pageMaker.setContentNum(contentNum); //한 페이지에 몇 개의 게시글을 보여줄지 지정
		pageMaker.setCurrentBlock(pageNum); //현재 페이지 블록이 몇 번인지 현재 페이지 번호를 통해서 지정
		pageMaker.setLastBlock(pageMaker.getTotalCount()); //마지막 블록 번호를 전체 게시글 수를 통해서 정한다.
		pageMaker.preNext(pageNum); //현재 페이지 번호로 화살표를 나타낼지 정한다.
		pageMaker.setStartPage(pageMaker.getCurrentBlock()); //시작 페이지를 페이지 블록 번호로 정한다.
		
		// 마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록 번호로 정한다.
		pageMaker.setEndPage(pageMaker.getLastBlock(), pageMaker.getCurrentBlock()); 
		
		return pageMaker;
	}
}
