<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<s:head/>
</head>
<body>
	<h2>Registration Form</h2>
	
	
	<s:form action="registerAction">
		<s:textfield name="firstName" key="global.firstName" />
		<s:textfield name="lastName" key="global.lastName" />
		<s:radio name="gender" list="{'Male','Female'}" key="global.gender" />
		<s:textfield name="age" key="global.age" />
		<s:textfield name="email" key="global.email" />
		<s:textarea name="address" cols="30" rows="7"></s:textarea>
		<s:select list="colors" name="selectedColor" 
		headerKey="None" headerValue="Select a color" label="Favourite color"></s:select>
		<s:checkbox name="subscription" value="true" label="Subscribe to our newslater"/>
		<s:checkboxlist list="hobbies" name="selectedHobbies" label="Hobbies"></s:checkboxlist>
		<s:reset value="Reset"></s:reset>
		<s:submit key="global.register" />
	</s:form>
	
	<s:url action="changeLocaleAction" var="urlEn">
		<s:param name="request_locale">en</s:param>
	</s:url>
	<a href="${ urlEn }">English</a>
	
	<s:url action="changeLocaleAction" var="urlFr">
		<s:param name="request_locale">fr</s:param>
	</s:url>
	<a href="${ urlFr }">Français</a>
	
	<s:url action="changeLocaleAction" var="urlDe">
		<s:param name="request_locale">de</s:param>
	</s:url>
	<a href="${ urlDe }">German</a>
	
	<table border="1" width="300">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Price</th>
		</tr>
		<s:iterator value="products" var="product">
			<tr>
				<td><s:property value="#product.productId"/></td>
				<td><s:property value="#product.productName"/></td>
				<td><s:property value="#product.productPrice"/></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
