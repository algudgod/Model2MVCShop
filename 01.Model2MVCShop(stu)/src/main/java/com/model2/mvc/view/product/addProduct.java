package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class addProduct extends Action {

	public String execute(	HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		// 등록 할 때 필요한 정보 값 설정.
		ProductVO productVO = new ProductVO();
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(request.getParameter("manuDate"));
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		productVO.setFileName(request.getParameter("fileName"));
			
		
		System.out.println(productVO);
		
		
		ProductService productservice = new ProductServiceImpl();
		productservice.addProduct(productVO);
		
		System.out.println("productVO"+ productVO); //null 체크
		
		request.setAttribute("ProductVO", productVO);
		
		return "forward:/product/getProduct.jsp";
		
		
	}

}
