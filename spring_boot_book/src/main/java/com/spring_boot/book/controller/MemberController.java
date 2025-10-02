package com.spring_boot.book.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.book.model.MemberVO;
import com.spring_boot.book.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memService;
	
	//로그인 폼 요청 처리
	@GetMapping("/member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	// 로그인 처리 : 비밀번호 암호화 하지 않은 경우
	/*	@ResponseBody
		@RequestMapping("/member/login")
		public String loginCheck(@RequestParam HashMap<String, Object> param,
												   HttpSession session) {
			// 로그인 체크 결과 : id와 pwd 전달하고 로그인 성공하면 id 반환
			String memId = memService.loginCheck(param);
			System.out.println(memId);
			String result = "fail";
			// id와 pwd 일치하면 
			if(memId != null) {
				// 로그인 성공하면 세션 변수 설정
				session.setAttribute("sid", memId);
				result = "success";
		}
				
			return result; // 뷰 페이지 이름이 아닌 데이터 반환 : @ResponseBody
		}
		*/
	
	
	
	//로그인 처리(비밀번호 암호화 한 경우) : 로그인 여부 서비스가 결정
	@ResponseBody
	@PostMapping("/member/login")
	public String loginCheck(@RequestParam HashMap<String, Object> param, HttpSession session) {
		
		String result =  memService.loginCheck(param);
		
		if(result.equals("success")) {
			//로그인 조건을 만족하면 로그인 처리(세션을 활용) : 세션변수에 id값을 저장
			session.setAttribute("sid", (String)param.get("id"));
			
		}
		return result;
	}
	
	//로그아웃 처리(세션유효성 종료)
	@GetMapping("/member/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//회원 가입 폼 요청 처리
	@GetMapping("/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	//id 중복 확인 처리
	@ResponseBody
	@PostMapping("/member/idCheck")
	public int idCheck(@RequestParam("id") String id) {
		int result=0;
		String id_res = memService.idCheck(id);
		
		if(id_res != null) { // null이면 id의 record값이 테이블에 없으므로 쓸 수 있는 id
			result = 1; // 1이면 중복 아이디, 0이면 사용가능
		}
		return result;
	}
	
	//회원 가입 요청 처리
	@PostMapping("/member/join")
	public String join(MemberVO vo, 
						@RequestParam("memHp1") String memHp1,
						@RequestParam("memHp2") String memHp2,
						@RequestParam("memHp3") String memHp3
						) {
		String memHp = memHp1 +"-" + memHp2 + "-" + memHp3;
		vo.setMemHP(memHp);
		memService.insertMember(vo);
		return "redirect:/member/loginForm";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
