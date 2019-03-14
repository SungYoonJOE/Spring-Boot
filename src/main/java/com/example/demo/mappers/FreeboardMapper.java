package com.example.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Freeboard;

@Mapper
public interface FreeboardMapper {

	public Freeboard selectFreeboardById(Long freeid);
	
	//public List<Freeboard> selectAllFreeboard();
	
	//public void insertFreeboard(@Param(value="freeboard")Freeboard freeboard);
	
}
