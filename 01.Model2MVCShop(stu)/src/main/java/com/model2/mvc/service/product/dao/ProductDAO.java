package com.model2.mvc.service.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.ProductVO;

public class ProductDAO {
	
	public ProductDAO() {
	}

	
	public ProductVO findProduct(int prodNo) throws Exception {
		
		ProductVO productVO = null;
		try {
//			Connection con = DBUtil.getConnection();
//			
//			String sql = "SELECT * FROM product where PROD_NO=?";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, prodNo);
//			ResultSet rs = pstmt.executeQuery();
					
			
			Connection con = DBUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM product where PROD_NO=?");
			pstmt.setInt(1, prodNo);
			ResultSet rs = pstmt.executeQuery();
			
			
			
			while (rs.next()) {
				productVO = new ProductVO();
				
				productVO.setProdNo(rs.getInt("PROD_NO"));
				productVO.setProdName(rs.getString("PROD_NAME"));	
				productVO.setProdDetail(rs.getString("PROD_DETAIL"));
				productVO.setManuDate(rs.getString("MANUFACTURE_DAY"));
				productVO.setPrice(rs.getInt("PRICE"));
				productVO.setFileName(rs.getString("IMAGE_FILE"));
				productVO.setRegDate(rs.getDate("REG_DATE"));
				
			}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productVO;
				
	}
	
	
	
	public void insertProduct(ProductVO productVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO product VALUES(seq_product_prod_no.nextval,"
				+ "?,?,?,?,?, sysdate)");
		
		
		pstmt.setString(1, productVO.getProdName());
		pstmt.setString(2, productVO.getProdDetail());
		pstmt.setString(3, productVO.getManuDate());
		pstmt.setInt(4, productVO.getPrice());
		pstmt.setString(5, productVO.getFileName());
		pstmt.executeUpdate();
		
		con.close();
	}
	
	//상품 리스트 반환
	public HashMap<String, Object> getProductList(SearchVO searchVO) throws Exception {
		
		Connection con= DBUtil.getConnection();
		
		String sql= "SELECT * FROM product ";
		if (searchVO.getSearchCondition() != null) {
			if(searchVO.getSearchCondition().equals("0")) {
				sql += "where PROD_NO LIKE '%" + searchVO.getSearchKeyword() + "%'";
			} else if (searchVO.getSearchCondition().equals("1")) {
				sql += "where PROD_NAME LIKE '%" + searchVO.getSearchKeyword() + "%'";				
			} else if (searchVO.getSearchCondition().equals("2")) {
				sql += "where PRICE LIKE '%" + searchVO.getSearchKeyword() + "%'";
			}
		}	
		
		sql += "order by PROD_NO";
		
		PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
															ResultSet.CONCUR_UPDATABLE);
		System.out.println(sql);
		ResultSet rs = pstmt.executeQuery();
		
		
		rs.last();
		int total = rs.getRow();
		System.out.println("로우의 수:" + total);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("count", new Integer(total));

		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		System.out.println("searchVO.getPage():" + searchVO.getPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());

		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
			
				ProductVO pvo = new ProductVO();
				
				
				pvo.setProdNo(rs.getInt("PROD_NO"));
				pvo.setProdName(rs.getString("PROD_NAME"));
				pvo.setProdDetail(rs.getString("PROD_DETAIL"));	
				pvo.setManuDate(rs.getString("MANUFACTURE_DAY"));
				pvo.setPrice(rs.getInt("PRICE"));
				pvo.setFileName(rs.getString("IMAGE_FILE"));
				pvo.setRegDate(rs.getDate("REG_DATE"));
				//pvo.setProTranCode(rs.getString("TRAN_STATUS_CODE"));				
				list.add(pvo);
				if (!rs.next())
					break;
			}
		}
		
		System.out.println("list.size() : " + list.size());
		map.put("list", list);
		System.out.println("map().size() : "+ map.size());

		con.close();
			
		return map;
	}


	public void updateProduct(ProductVO productVO) throws Exception {
		
		System.out.println("업데이트다(PRODUCTDAO)" +productVO);
		
		Connection con = DBUtil.getConnection();
		
		String sql = "UPDATE product set PROD_NAME=?, PROD_DETAIL=?, MANUFACTURE_DAY=?, PRICE=?, IMAGE_FILE=?"
				+" where PROD_NO=?";
			
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, productVO.getProdName());
		pstmt.setString(2, productVO.getProdDetail());
		pstmt.setString(3, productVO.getManuDate());
		pstmt.setInt(4, productVO.getPrice());
		pstmt.setString(5, productVO.getFileName());
		pstmt.setInt(6, productVO.getProdNo());
		
		pstmt.executeUpdate();
		
		
		con.close();
			
		}
		
	}
			

