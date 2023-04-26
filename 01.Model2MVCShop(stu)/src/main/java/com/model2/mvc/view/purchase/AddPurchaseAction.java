package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.vo.UserVO;


public class AddPurchaseAction extends Action {

	public String execute(	HttpServletRequest request,
									HttpServletResponse response) throws Exception {
		

		ProductService productService = new ProductServiceImpl();
		
		HttpSession session = request.getSession();
		
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		ProductVO productVO = productService.getProduct(prodNo);
		
		System.out.println("prodNo�� �� �Ѿ�Դ�?"+prodNo);
		
		UserVO userVO = (UserVO)session.getAttribute("uservo");
		
		System.out.println();
		
		PurchaseVO purchaseVO = new PurchaseVO();
		
		purchaseVO.setPurchaseProd(productVO);
		purchaseVO.setBuyer(userVO);
		
		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));
		purchaseVO.setReceiverName(request.getParameter("receiverName"));
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
		purchaseVO.setDivyAddr(request.getParameter("receiverAddr"));
		purchaseVO.setDivyRequest(request.getParameter("receiverRequest"));
		purchaseVO.setDivyDate(request.getParameter("receiverDate"));
		

		
		System.out.println("purchaseVO�� ����� �� ���Դ�?"+purchaseVO);
		
		
		PurchaseService purchaseService=new PurchaseServiceImpl();
		purchaseService.addPurchase(purchaseVO);
		
		request.setAttribute("productvo", productVO);
		request.setAttribute("purchasevo", purchaseVO);
		return "forward:/purchase/addPurchase.jsp";
		
		
		
		
				
	}
}



