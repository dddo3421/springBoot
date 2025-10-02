package com.spring_boot.projectEx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	// 시작 시 index 페이지 열기
	@GetMapping("/") 
	public String viewIndex() {
		return "index"; // index.jsp 파일의 이름 반환
	}
}
