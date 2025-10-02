package com.spring_boot.book.dao;

import com.spring_boot.book.model.MemberVO;

public interface IMemberDAO {
//	public String loginCheck(HashMap<String, Object> map);
	public String loginCheck(String id);
	public String idCheck(String id);
	public void insertMember(MemberVO vo);
	
}
