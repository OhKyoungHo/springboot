package com.example.service;

import com.example.domain.MemberVO;

public interface MemberService {
	
	public int insertMemberForm(MemberVO vo);
	
	MemberVO login(MemberVO vo);

}
