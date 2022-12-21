<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Namespace</title>
</head>
<body>
	<h1>Namespace Test</h1>
	<s:form action="/product/getDetails">
		<s:submit value="Get Product Details"/>
	</s:form>
	<s:form action="/user/getDetails">
		<s:submit value="Get User Details"/>
	</s:form>
</body>
</html>