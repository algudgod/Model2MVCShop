package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.dao.UserDAO;
import com.model2.mvc.service.user.vo.UserVO;

/**
 * @author algud
 *
 */
public class PurchaseDAO {
	
	//Method
	public void insertPurchase(PurchaseVO purchaseVO) {
	
		try {				
//			Connection con = DBUtil.getConnection();
//			
//			String sql = "INSERT INTO transaction "
//					+ "VALUES(seq_transaction_tran_no.nextval,"
//							+ "?, ?, ?, ?, ?, ?, ?, ?, ? sysdate)";			
//			PreparedStatement pstmt = con.prepareStatement(sql);
			
			Connection con = DBUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO transaction"
					+ "VALUES(seq_transaction_tran_no.nextval,?,?,?,?,?,?,?,?,sysdate");
			
			pstmt.setInt(1, purchaseVO.getPurchaseProd().getProdNo());
			pstmt.setString(2, purchaseVO.getBuyer().getUserId());
			pstmt.setString(3, purchaseVO.getPaymentOption());
			pstmt.setString(4, purchaseVO.getReceiverName());
			pstmt.setString(5, purchaseVO.getReceiverPhone());
			pstmt.setString(6, purchaseVO.getDivyAddr());
			pstmt.setString(7, purchaseVO.getDivyRequest());
			pstmt.setString(8, purchaseVO.getTranCode());
			pstmt.setString(9, purchaseVO.getDivyDate());	
			pstmt.executeUpdate();
			
			con.close();
			
		} catch(Exception e) {
			 e.printStackTrace();
		}		
	}
	
	public PurchaseVO findPurchase(int tranNo) throws Exception {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM transaction where TRAN_NO=?");
		pstmt.setInt(1, tranNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		PurchaseVO purchaseVO = new PurchaseVO();
		ProductVO productVO = new ProductVO();
		UserVO userVO = new UserVO();
		
		while (rs.next()) {

			purchaseVO.setTranNo(tranNo);
			purchaseVO.setPurchaseProd(productVO);
			purchaseVO.setBuyer(userVO);
			purchaseVO.setPaymentOption(rs.getString("PAYMENT_OPTION"));
			purchaseVO.setReceiverName(rs.getString("RECEIVER_NAME"));
			purchaseVO.setReceiverPhone(rs.getString("RECEIVER_PHONE"));
			purchaseVO.setDivyAddr(rs.getString("DLVY_ADDR"));
			purchaseVO.setDivyRequest(rs.getString("DLVY_DATE"));
			purchaseVO.setTranCode(rs.getString("TRAN_STATUS_CODE"));
			purchaseVO.setOrderDate(rs.getDate("ORDER_DATA"));
			purchaseVO.setDivyDate(rs.getString("DLVY_DATE"));
		
		}
		con.close();
		
		return purchaseVO;
			
	}

	
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		
//		String sql = "update TRANSACTION set PAYMENT_OPTION=?, RECEIVER_NAME=?, RECEIVER_PHONE=?"
//				+ "DLVY_ADDR=?, DLVY_REQUEST=?, DLVY_DATE=?";	
//		PreparedStatement pstmt = con.prepareStatement(sql);
		
		PreparedStatement pstmt = con.prepareStatement("UPDATE transaction SET"
				+ "PAYMENT_OPTION=?, RECEIVER_NAME=?, RECEIVER_PHONE=?"
				+ "DLVY_ADDR=?, DLVY_REQUEST=?, DLVY_DATE=? WHERE TRAN_NO=?");
		
		pstmt.setString(1, purchaseVO.getPaymentOption());
		pstmt.setString(2, purchaseVO.getReceiverName());
		pstmt.setString(3, purchaseVO.getReceiverPhone());
		pstmt.setString(4, purchaseVO.getDivyAddr());
		pstmt.setString(5, purchaseVO.getDivyRequest());
		pstmt.setString(6, purchaseVO.getDivyDate());
		pstmt.executeUpdate();
		
		con.close();
		
	}
	
	public void updateTrancode(PurchaseVO purchaseVO) throws Exception{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("UPDATE transaction SET"
				+ "TRAN_STATUS_CODE=? WHERE TRAN_NO=?");
		
		pstmt.setString(1, purchaseVO.getTranCode());
		pstmt.setInt(2, purchaseVO.getTranNo());
		pstmt.executeUpdate();
		con.close();
	}
	
	/* 
	 executeUpdate(String sql)는 조회문(SELECT 등)을 제외한(CREATE, DROP, INSERT,UPDATE 등)에 사용된다.
	 executeQuery(String sql)는 조회문을 실행할 목적으로 사용한다.
	*/
	
	
	
	
//		
//		rs.last();
//		int total = rs.getRow();
//		System.out.println("로우의 수:" + total);
//
//		HashMap<String,Object> map = new HashMap<String,Object>();
//		map.put("count", new Integer(total));
//
//		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
//		System.out.println("searchVO.getPage():" + searchVO.getPage());
//		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());
//		
//		ArrayList<PurchaseVO> list = new ArrayList<PurchaseVO>();
//		if (total > 0) {
//			for (int i = 0; i < searchVO.getPageUnit(); i++) {
//				
//				PurchaseVO purchaseVO = new PurchaseVO();
//				UserVO userVO = new UserVO();
//				ProductVO productVO = new ProductVO();
//				
//				purchaseVO.setPurchaseProd(productVO);
//				purchaseVO.setBuyer(userVO);
//				purchaseVO.setPaymentOption(rs.getString("PAYMENT_OPTION"));
//				purchaseVO.setReceiverName(rs.getString("RECEIVER_NAME"));
//				purchaseVO.setReceiverPhone(rs.getString("RECEIVER_PHONE"));
//				purchaseVO.setDivyAddr(rs.getString("DLVY_ADDR"));
//				purchaseVO.setDivyRequest(rs.getString("DLVY_REQUEST"));
//				purchaseVO.setTranCode(rs.getString("TRAN_STATUS_CODE"));
//				purchaseVO.setOrderDate(rs.getDate("ORDER_DATA"));
//				purchaseVO.setDivyDate(rs.getString("DLVY_DATE"));;
//				
//				list.add(purchaseVO);
//				if (!rs.next())
//					break;
//						
//			}
//		}
//		System.out.println("list.size() : " + list.size());
//		map.put("list", list);
//		System.out.println("map().size() : "+ map.size());
//
//		con.close();
//			
//		return map;
//	}
}
