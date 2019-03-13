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
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@DynamicInsert //insert할  때 null은 포함 안 됨.
@Table(name="board")
public class Freeboard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long freeid;
	
	@Column(name="content")
	private String content;
	
	@Column(name="title")
	private String title;
	
	@Column(name="writer")
	private String writer;
	

}
