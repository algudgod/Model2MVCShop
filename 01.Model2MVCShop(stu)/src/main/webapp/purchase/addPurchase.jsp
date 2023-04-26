<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="com.model2.mvc.service.user.vo.*" %>
<%@ page import="com.model2.mvc.service.product.vo.*" %>
<%@ page import="com.model2.mvc.service.purchase.vo.*" %>


<%	
	PurchaseVO purchasevo = (PurchaseVO)request.getAttribute("purchasevo"); 
	
	System.out.println("Purchasevo 찍힙니까"+purchasevo);
%>

<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="addPurchase" action="/updatePurchaseView.do?tranNo=0" method="post">


다음과 같이 구매가 되었습니다.

<table border=1>
	<tr>
		<td>물품번호</td>
		<td><%= purchasevo.getPurchaseProd().getProdNo() %></td>
		<td></td>
	</tr>
	<tr>
		<td>구매자아이디</td>
		<td><%=purchasevo.getBuyer().getUserId()%></td>
		<td></td>
	</tr>
	<tr>
		<td>구매방법</td>
		<td>
		
		
		<% if(purchasevo.getPaymentOption().equals("1")) { %>
		현금구매
		
		<% }else{  %>
		신용카드구매
		<% } %>
		
		
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자이름</td>
		<td><%=purchasevo.getBuyer().getUserName() %></td>
		<td></td>
	</tr>
	<tr>
		<td>구매자연락처</td>
		<td><%=purchasevo.getReceiverPhone() %></td>
		<td></td>
	</tr>
	<tr>
		<td>구매자주소</td>
		<td><%=purchasevo.getDivyAddr() %></td>
		<td></td>
	</tr>
		<tr>
		<td>구매요청사항</td>
		<td><%=purchasevo.getDivyRequest() %></td>
		<td></td>
	</tr>
	<tr>
		<td>배송희망일자</td>
		<td><%=purchasevo.getDivyDate() %></td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>