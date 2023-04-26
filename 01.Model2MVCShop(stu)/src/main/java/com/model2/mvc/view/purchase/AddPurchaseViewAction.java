package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class AddPurchaseViewAction extends Action {

	public String execute(	HttpServletRequest request,
									HttpServletResponse response) throws Exception {
		
//			System.out.println("init AddPurchaseViewAction"+request.getParameter("userId"));
			System.out.println("init AddPurchaseViewAction"+request.getParameter("prodNo"));
			
			
			//String userId = request.getParameter("userId");
			int prodNo= Integer.parseInt(request.getParameter("prodNo"));
			
			
//			UserService userService = new UserServiceImpl();
//			UserVO uservo = userService.getUser(userId); 
			
			ProductService productService=new ProductServiceImpl();
			ProductVO productvo = productService.getProduct(prodNo);		
			
//			request.setAttribute("uservo", uservo);	 세션에서 가져올 것이었는데 파라미터로 가져오려고함.
			request.setAttribute("productvo", productvo);
			
			return "forward:/purchase/addPurchaseView.jsp";
				
	}
}



