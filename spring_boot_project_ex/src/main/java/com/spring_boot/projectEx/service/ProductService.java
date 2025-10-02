package com.spring_boot.projectEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dao.IProductDAO;
import com.spring_boot.projectEx.model.ProductVO;

@Service
public class ProductService implements IProductService{
	@Autowired
	@Qualifier("IProductDAO")
	IProductDAO dao;
	
	@Override
	public ArrayList<ProductVO> ctgListProduct(String ctgId) {
		return dao.ctgListProduct(ctgId);
	}
	
	@Override
	public String prdNoCheck(String prdNo) {
		return dao.prdNoCheck(prdNo);
	}
	
	
	@Override
	public ArrayList<ProductVO> productSearch(HashMap<String, Object> map) {
		return dao.productSearch(map);
	}


	@Override
	public ArrayList<ProductVO> listAllProduct() {		
		return dao.listAllProduct();
	}

	@Override
	public void insertProduct(ProductVO vo) {
		dao.insertProduct(vo);		
	}

	@Override
	public void updateProduct(ProductVO prdVo) {
		dao.updateProduct(prdVo);		
	}

	@Override
	public void deleteProduct(String prdNo) {
		dao.deleteProduct(prdNo);		
	}

	@Override
	public ProductVO detailViewProduct(String prdNo) {
		
		return dao.detailViewProduct(prdNo);
	}


}
