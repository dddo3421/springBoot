package com.spring_boot.book.service;

import java.util.HashMap;

import com.spring_boot.book.model.MemberVO;

public interface IMemberService {
	public String loginCheck(HashMap<String, Object> map);
	public String idCheck(String id);
	public void insertMember(MemberVO vo);
	
}
