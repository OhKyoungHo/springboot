package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.FileVO;

@Mapper
public interface FileDAO {
	//파일 등록
	public void insertFile(FileVO vo);
	//파일 번호(id) 찾기
	public long selectId();
	//파일 찾기
	public FileVO selectFile(FileVO vo);
}
