<%@include file="index.jsp" %>
<%
int n = Integer.parseInt(request.getParameter("n"));
%>
<p style="color: green; font-weight: bold;">
Create table of <%=n%> number.
<%
for(int i=1;i<=10;i++)
{
    out.println("<br/>"+n+" X "+i+" = "+(n*i));
}
%>
</p>