<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Termwork project</title>
<body>
	<h2>Update Your Details</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Update User</h3>
	<form method="POST" name="update_customer"
		action="<%=request.getContextPath()%>/update/customer">
		<input hidden="hidden" name="id" value="${id}" type="text" />
		FirstName: <input name="firstName" value="${customer.firstName}"
			type="text" /> <br /> <br /> LastName: <input name="lastName"
			value="${customer.lastName}" type="text" /> <br /> <br /> Email: <input
			name="email" value="${customer.email}" type="text" /> <br /> <br />
		Phone Number: <input name="phoneNumber"
			value="${customer.phoneNumber}" type="text" /> <br /> <br /> <input
			value="Update User" type="submit" />
	</form>
</body>
</html>