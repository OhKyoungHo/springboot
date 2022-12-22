package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.MemberVO;

@Mapper
public interface MemberDAO {
	int insertMemberForm(MemberVO vo);
	
	MemberVO login(MemberVO vo);
	
}
