package com.example.demo.pagemaker;

public class PageMaker {
	private int totalCount; //전체 게시글 개수
	private int pageNum; //현재 페이지 번호
	private int contentNum=10; //한 페이지에 표시할 게시글 개수
	private int startPage=1;//현재 페이지 블록의 시작페이지
	private int endPage=5;//현재 페이지 블록의 마지막 페이지
	private boolean prev=false; //이전 페이지로 가는 화살표
	private boolean next;
	private int currentBlock;//현재 페이지 블록
	private int lastBlock; //마지막 페이지 블록
	
	public void prevNext(int pageNum) {
		if(pageNum >0 && pageNum<6) {
			setPrev(false);
			setNext(true);
		}
		else if(getLastBlock() == getCurrentBlock()) {
			setPrev(true);
			setNext(false);
		}
		else {
			setPrev(true);
			setNext(true);
		}
	}
	
	public int calcpage(int totalCount, int contentNum) {
		int totalPage = totalCount/contentNum;
		if(totalCount % contentNum >0) {
			totalPage++;
		}
		return totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getContentNum() {
		return contentNum;
	}

	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}

	public int getStartPage() {
		return startPage;
	}
	/*
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}*/
	public void setStartPage(int currentBlock) {
		this.startPage = (currentBlock * 5)-4;
		//1 2 3 4 5
		//6 7 8 9 10
		//11 12 13 
	}

	public int getEndPage() {
		return endPage;
	}
/*
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
*/
	
	public void setEndPage(int getLastBlock, int getCurrentBlock) {
		if(getLastBlock == getCurrentBlock) {
			this.endPage = calcpage(getTotalCount(), getContentNum());//페이지 개수를 끝페이지로 지정
		}
		else {
			this.endPage = getStartPage()+4;//시작 페이지 + 4를 끝페이지로 지정
		}
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int pageNum) {//페이지 번호 5 들어옴
		//페이지 번호를 통해서 구함
		//페이지 번호 / 페이지 그룹 안의 개수
		//1p 1/5 -> 0.2
		//5p 5/5 -> 1 -> 나머지는 0
		//this.currentBlock = currentBlock;
		this.currentBlock = pageNum/5;
		if(pageNum%5>0) {
			this.currentBlock++;
			System.out.println(this.currentBlock); //5페이지로 갔는데 현재 블록이 증가하지 않음
		}
	}

	public int getLastBlock() {
		return lastBlock;
	}

	public void setLastBlock(int totalCount) {
		
		//this.lastBlock = lastBlock;
		this.lastBlock = totalCount/(5*this.contentNum);
		if(totalCount % (5 * this.contentNum)>0) {
			this.lastBlock++;
		}
	}
	
	
	
}
	
