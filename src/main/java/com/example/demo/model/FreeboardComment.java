package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="comment")
public class FreeboardComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	
	@Column(name="content")
	private String content;
	
	@Column(name="writeDate")
	private LocalDateTime write_date;
	
	@Column(name="writer")
	private String writer;
	
	@Column(name = "comment_origin_id")
	private Long commentOriginId;
	
	@Column(name="comment_level")
	private int commentLevel;

	//@ManyToOne(targetEntity = Freeboard.class)
	//@JoinColumn(foreignKey = @ForeignKey(name="freeId"))
	private Long freeId;
}
