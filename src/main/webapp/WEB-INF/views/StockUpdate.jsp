<!DOCTYPE html>
<%@page import="com.inventoryManagement.model.StockModel"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login with boot</title>
</head>
<body>
	<form method="post" action="/updateStock">
		<fieldset>
			<legend>New Stock form</legend>
			<%StockModel stock=(StockModel)request.getAttribute("Stock"); %>
			<table>
			<tr>
					<td>Stock Id</td>
					<td><input type="text" name="stockId" value="<%=stock.getStockId() %>" readonly ></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%=stock.getName() %>" readonly ></td>
				</tr>
			<tr>
					<td>Material</td>
					<td><input type="text" name="material" value="<%=stock.getMaterial() %>" readonly ></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><input type="text" name="category" value="<%=stock.getCategory() %>" readonly ></td>
				</tr>
				<tr>
					<td>SubCategory</td>
					<td><input type="text" name="subCategory" value="<%=stock.getSubCategory() %>" readonly ></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price" value="<%=stock.getPrice() %>"  ></td>
				</tr>
			<tr>
					<td>Discount</td>
					<td><input type="text" name="discount" value="<%=stock.getDiscount() %>"  ></td>
				</tr>
				<tr>
					<td>Size</td>
					<td><input type="text" name="size" value="<%=stock.getSize() %>" readonly ></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><input type="text" name="quantity" value="<%=stock.getQuantity() %>" ></td>
				</tr>
				<tr>
					<td><input type="Submit" value="Update"></td>
					<td><input type="button" value="Cancel" onclick="history.back()"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>