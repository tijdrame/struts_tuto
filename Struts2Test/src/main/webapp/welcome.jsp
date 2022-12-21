<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<s:head/>
</head>
<body>
	<s:form action="testAction">
		<s:textfield name="firstName" label="Your name:"></s:textfield>
		<s:submit value="Submit"></s:submit>
	</s:form>
</body>
</html>