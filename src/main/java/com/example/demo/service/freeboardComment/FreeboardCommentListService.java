package com.example.demo.service.freeboardComment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FreeboardComment;
import com.example.demo.repository.FreeboardCommentRepository;

@Service
public class FreeboardCommentListService {
	
	@Autowired
	private FreeboardCommentRepository freeboardCommentRepository;

	public List<FreeboardComment> getList(Long freeId){
		List<FreeboardComment> freeboardCommentList = freeboardCommentRepository.findByFreeId(freeId);
		int commentListSize = freeboardCommentList.size();
		if(commentListSize == 0) {
			return new ArrayList<FreeboardComment>();
		}
		
		LinkedList<FreeboardComment> CommentLinkedList = new LinkedList<FreeboardComment>();
		
        for (int i = 0; i < CommentLinkedList.size(); i++) {
            if (freeboardCommentList.get(i).getCommentLevel() ==0) { //레벨0 댓글들을 먼저 연결리스트에 보관
            	CommentLinkedList.add(freeboardCommentList.get(i)); //1개씩 추가
            }
        }
        
        for(int i=0; i<freeboardCommentList.size(); i++) {
        	if(freeboardCommentList.get(i).getCommentLevel() != 0) {
        		long origin_id = freeboardCommentList.get(i).getCommentOriginId();
        		for(int j=0; j<CommentLinkedList.size(); j++) {
        			if(CommentLinkedList.get(j).getCommentOriginId() == origin_id) {
        				CommentLinkedList.add(j+1, freeboardCommentList.get(j));
        			}
        		}
        	}
        }
        return freeboardCommentList;
	}
}
