package com.spring_boot.projectEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dao.ICartDAO;
import com.spring_boot.projectEx.model.CartVO;


@Service
public class CartService implements ICartService {
	
	@Autowired
	@Qualifier("ICartDAO")
	ICartDAO dao;
	
	@Override
	public void insertCart(CartVO vo) {
		dao.insertCart(vo);
	}

	@Override
	public int checkPrdInCart(String prdNo, String memId) {
		//dao의 동일상품 확인 메소드에서 파라미터 map 형태로 요구, dao 요구에 따라 서비스 해당 data 가공처리
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("prdNo", prdNo);
		map.put("memId",memId);
		return dao.checkPrdInCart(map);
	}

	@Override
	public void updateQtyInCart(CartVO vo) {
		dao.updateQtyInCart(vo);	
	}

	@Override
	public ArrayList<CartVO> cartList(String memId) {
		return dao.cartList(memId);
	}

	@Override
	public void deleteCart(ArrayList<String> chkArr) {
		dao.deleteCart(chkArr);		
	}

}
