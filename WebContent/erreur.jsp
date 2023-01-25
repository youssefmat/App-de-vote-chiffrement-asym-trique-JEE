<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h2{
width: 100%;
background-color: #962121;
color: white;
}
</style>
</head>
<body>
<% String msg = (String)session.getAttribute("erreur");
String pageAuth = (String)session.getAttribute("page");
System.out.println(msg);
System.out.println(request.getContextPath());
%>
<h2><%=msg %></h2>
<br>
<a href="<%=request.getContextPath() 
                              + pageAuth%>">Essayez une autre fois ...</A>
</body>
</html>