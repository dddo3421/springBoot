package com.spring_boot.projectEx.service;

import java.util.ArrayList;

import com.spring_boot.projectEx.model.CartVO;

public interface ICartService {
	//장바구니 및 주문관련 작업 처리시 필요한 메소드들
	//장바구니 추가
	public void insertCart(CartVO vo);
	//장바구니 동일상품 존재 여부 확인 확인 메소드 : 동일 상품 수 : 파라미터 (상품번호, 회원번호) - cart 테이블이 여러 명의 회원이 여러 개의 상품을 담을 수도 있음
	public int checkPrdInCart(String prdNo, String memId);
	//동일상품 존재 시 수량 변경 메소드
	public void updateQtyInCart(CartVO vo);
	
	//특정 회원의 카트 리스트
	public ArrayList<CartVO> cartList(String memId);
	//장바구니 상품 삭제
	public void deleteCart(ArrayList<String> chkArr);
	 
}
