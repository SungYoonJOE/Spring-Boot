package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Freeboard;

public interface FreeboardRepository extends JpaRepository<Freeboard, Long> {
		
	Freeboard findByTitleAndWriter(String title, String writer);
}
