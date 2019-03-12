package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FreeboardComment;

public interface FreeboardCommentRepository extends JpaRepository<FreeboardComment, Long> {

	//List<FreeboardComment> findAllByFreeId(Long freeId); //freeId를 통해 모든 개체를 가져오기
	List<FreeboardComment> findByFreeId(Long freeId); //freeId를 통해 모든 개체를 가져오기
}
