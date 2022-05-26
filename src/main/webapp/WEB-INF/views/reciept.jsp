<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Print Bill</title>
</head>
<body>
<%@include file="BillingPage.jsp" %>
<div>

<p><iframe src="c:\reports\"+<%=request.getAttribute("fileName")%>></iframe>
<%-- <%
String fileName=(String)request.getAttribute("fileName");
String filePath="C:\\reports";
response.setContentType("APPLICATION/OCTET-STREAM");
response.setContentType("content.disposition");
%>
 --%>
<%=request.getAttribute("fileName")%>
is the name of your file downloaded at location "C:\reports".
</p>
</div>
<div><button>home</button></div>
</body>
</html>