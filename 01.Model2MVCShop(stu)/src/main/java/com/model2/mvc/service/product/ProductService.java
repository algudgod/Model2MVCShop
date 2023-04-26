package com.model2.mvc.service.product;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.vo.ProductVO;

public interface ProductService {
	
		//void인 이유: 집어 넣고 끝
	
	public ProductVO getProduct(int productVO) throws Exception;
	
					//Generic
	public HashMap<String, Object> getProductList(SearchVO searchVO) throws Exception;
		
	public void addProduct(ProductVO productVO) throws Exception;
	
	public void updateProduct(ProductVO productVO) throws Exception;
	

	
	
}
