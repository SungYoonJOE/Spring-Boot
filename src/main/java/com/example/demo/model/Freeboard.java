package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="board")
public class Freeboard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bid")
	private Long freeid;
	
	@Column(name="b_content")
	private String content;
	
	@Column(name="b_title")
	private String title;
	
	@Column(name="b_pid")
	private String writer;

}
