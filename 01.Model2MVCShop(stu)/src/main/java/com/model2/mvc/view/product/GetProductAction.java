package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class GetProductAction extends Action {
	
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		
		System.out.println(prodNo);
		
		ProductService productService = new ProductServiceImpl();
		ProductVO productVO = productService.getProduct(prodNo);
		
		System.out.println("menu=search, getProductAction:"+productVO);
		request.setAttribute("prodvo", productVO);
		
		return "forward:/product/readProduct.jsp";

		
	}

}
