package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Entity
@DynamicInsert //insert할  때 null은 포함 안 됨.
@Table(name="board")
public class Freeboard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long bid;
	
	@Column(name="b_content")
	private String content;
	
	@Column(name="b_title")
	private String title;
	
	@Column(name="b_pid")
	private String bPid;
	
	

}
