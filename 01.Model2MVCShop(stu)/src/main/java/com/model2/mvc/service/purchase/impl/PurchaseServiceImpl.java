package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class PurchaseServiceImpl implements PurchaseService {
	
	private PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		purchaseDAO = new PurchaseDAO();
	}

	@Override
	public void addPurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.insertPurchase(purchaseVO);		
	}
	
	@Override
	public HashMap<String, Object> getPurchasetList(SearchVO searchVO) throws Exception {
		return null; //purchaseDAO.getPurchaseList(searchVO);
	}

	@Override
	public PurchaseVO getPurchase(int purchaseVO) throws Exception {
		return null; //purchaseDAO.findPurchase(purchaseVO);
	}

	@Override
	public HashMap<String, Object> getSaleList(SearchVO searchVO) throws Exception {
		return null;
	}

	@Override
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.getClass();
		
	}

	@Override
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.getClass();
		
	}
	
}
	
	
