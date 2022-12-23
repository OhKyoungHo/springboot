package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public int insertMemberForm(MemberVO vo) {
		System.out.println("회원정보 입력완료");
		return memberDAO.insertMemberForm(vo);
		
	}
	@Override
	public MemberVO login(MemberVO vo) {
		System.out.println("회원정보 입력완료");
		return memberDAO.login(vo);
	}

}
