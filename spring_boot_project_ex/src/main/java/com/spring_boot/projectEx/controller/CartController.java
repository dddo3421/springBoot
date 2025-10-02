package com.spring_boot.projectEx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.projectEx.model.CartVO;
import com.spring_boot.projectEx.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	
	//장바구니 
	// 로그인 된 상태에서만 요청이 가능하므로 세션변수 sid가 저장되어 있어야 함
	@PostMapping("/product/insertCart")
	public String insertCart(CartVO vo, HttpSession session) { 
		String memId = (String)session.getAttribute("sid");
		vo.setMemId(memId);
		
		//장바구니에 상품을 추가하기 위한 로직
		//1. 기존 장바구니에 동일 상품 있는지 확인
		int count = cartService.checkPrdInCart(vo.getPrdNo(),memId);
		
		if(count==0) {
			cartService.insertCart(vo); // 장바구니에 없으면 상품정보 추가
		}else {
			cartService.updateQtyInCart(vo); // 있으면 수량 변경
		}
		
		//장바구니 목록 출력		
		return("redirect:/product/cartListView");
	}
	
	//로그인 된 회원이 요청한 장바구니 목록 보기 요청 처리
	@RequestMapping("/product/cartListView")
	public String cartList(HttpSession session, Model model) {
		String memId = (String)session.getAttribute("sid"); //요청을 한 회원 id
		ArrayList<CartVO> cartList = cartService.cartList(memId);
		model.addAttribute("cartList", cartList);
		
		return("product/cartListView");
	}
	
	//장바구니 목록 삭제 -> 파라미터로 배열전달 ArrayList에 받아서 서비스로 전달
	@ResponseBody
	@PostMapping("/product/deleteCart")
	public int deleteCart(@RequestParam("chkbox") ArrayList<String> chkArr) {
		int result = 0;
		
		//서비스에서 ArrayList 전달
		if(chkArr != null) {
			cartService.deleteCart(chkArr);
			result = 1;
		}
		return result;
	}
	
	
	
	
	
}
