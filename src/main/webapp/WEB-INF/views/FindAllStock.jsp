<%@page import="com.inventoryManagement.model.StockModel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

<%if(session.getAttribute("userName")==null)
	response.sendRedirect("/login");
	%>
	<h1>Welcome <%= session.getAttribute("userName")%></h1>
	
	<form class="form-control">
		<fieldset>
		<legend>All Stock LIST</legend>
		<Table border="2" class="table table-striped">
			<tr>
				<th>Stock Id</th>
				<th>Name</th>
				<th>Material</th>
				<th>Category</th>
				<th>SubCategory</th>
				<th>Price</th>
				<th>Discount</th>
				<th>Size</th>
				<th>Quantity</th>
			</tr>
			<%
			List<StockModel> stockRecord = (List<StockModel>) request.getAttribute("records");		
			int c=11;
			for (StockModel stock : stockRecord) {
				String str="alpha";
				str="alpha"+c++;
				
			%>
			<tr>
				<td><%=str%></td>
				<td><%=stock.getName()%></td>
				<td><%=stock.getMaterial()%></td>
				<td><%=stock.getCategory()%></td>
				<td><%=stock.getSubCategory()%></td>
				<td><%=stock.getPrice()%></td>
				<td><%=stock.getDiscount()%></td>
				<td><%=stock.getSize()%></td>
				<td><%=stock.getQuantity()%></td>
				
				<td>
				
				   <a href='/stockUpdateForm/<%=stock.getStockId()%>'>
				   <Input type="button" value="Update" class="btn btn-outline-info">
				   </a>
				 </td>
				<td>
				    <a href="/deleteStock/<%=stock.getStockId()%>" >
				    <Input type="button" value="Delete" class="btn btn-outline-danger">				      
				    </a>
				 </td>
					
				<%
				}
				%>
			</tr>
			  <tr>
				 <td colspan="2">
					   <a href="/saveStockForm"><input type="button" value="Add New Stock" class="btn btn-primary btn-lg"></a>
				 </td>
					
					 
				 <td>
					    <input type="button" value="Go back!" onclick="history.back()" class="btn btn-secondary btn-lg">
				 </td>
				</tr>
		</Table>
		
		</fieldset>
	</form>
</body>
</html>