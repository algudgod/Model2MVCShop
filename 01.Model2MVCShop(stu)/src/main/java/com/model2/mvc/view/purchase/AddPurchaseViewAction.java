package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public class AddPurchaseViewAction extends Action {

	public String execute(	HttpServletRequest request,
							HttpServletResponse response) throws Exception {	

		//구매를 위한 화면 요청
		
		//	int prodNo = Integer.parseInt(request.getParameter("prodNo"));	
		//	ProductService productService = new ProductServiceImpl();
		//	ProductVO productVO = productService.getProduct(prodNo);
		//	System.out.println("프로덕트뷰액션내부"+productVO);
		//	request.setAttribute("productvo", productVO);
		
		
		int prodNo = Integer.parseInt(request.getParameter("prod_no"));
		
		ProductService productService = new ProductServiceImpl();
		ProductVO productVO = productService.getProduct(prodNo);
		System.out.println(productVO);
		
//		PurchaseService purchaseService = new PurchaseServiceImpl();
//		PurchaseVO purchaseVO = purchaseService.getPurchase(prodNo);
//		System.out.println("PurchaseViewAction"+purchaseVO);
		
		request.setAttribute("productvo", productVO);
//		request.setAttribute("purchasevo", purchaseVO);
		


		return "forward:/purchase/addPurchaseView.jsp";
	}
}


