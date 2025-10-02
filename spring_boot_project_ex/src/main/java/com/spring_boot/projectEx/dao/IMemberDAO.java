package com.spring_boot.projectEx.dao;

import java.util.HashMap;

import com.spring_boot.projectEx.model.MemberVO;

public interface IMemberDAO {
//	public String loginCheck(HashMap<String, Object> map);
	public String loginCheck(String id);
	public String idCheck(String id);
	public void insertMember(MemberVO vo);
	
}
