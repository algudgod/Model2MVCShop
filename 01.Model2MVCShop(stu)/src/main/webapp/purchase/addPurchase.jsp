<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="com.model2.mvc.service.user.vo.*" %>
<%@ page import="com.model2.mvc.service.product.vo.*" %>
<%@ page import="com.model2.mvc.service.purchase.vo.*" %>


<%	
	PurchaseVO purchasevo = (PurchaseVO)request.getAttribute("purchasevo"); 
	
	System.out.println("Purchasevo �����ϱ�"+purchasevo);
%>

<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="addPurchase" action="/updatePurchaseView.do?tranNo=0" method="post">


������ ���� ���Ű� �Ǿ����ϴ�.

<table border=1>
	<tr>
		<td>��ǰ��ȣ</td>
		<td><%= purchasevo.getPurchaseProd().getProdNo() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�����ھ��̵�</td>
		<td><%=purchasevo.getBuyer().getUserId()%></td>
		<td></td>
	</tr>
	<tr>
		<td>���Ź��</td>
		<td>
		
		
		<% if(purchasevo.getPaymentOption().equals("1")) { %>
		���ݱ���
		
		<% }else{  %>
		�ſ�ī�屸��
		<% } %>
		
		
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>�������̸�</td>
		<td><%=purchasevo.getBuyer().getUserName() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�����ڿ���ó</td>
		<td><%=purchasevo.getReceiverPhone() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�������ּ�</td>
		<td><%=purchasevo.getDivyAddr() %></td>
		<td></td>
	</tr>
		<tr>
		<td>���ſ�û����</td>
		<td><%=purchasevo.getDivyRequest() %></td>
		<td></td>
	</tr>
	<tr>
		<td>����������</td>
		<td><%=purchasevo.getDivyDate() %></td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>