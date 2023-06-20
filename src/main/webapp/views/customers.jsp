<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Registration Page</title>
<body>
	<h2>Register Yourself</h2>
	<a href="<%=request.getContextPath()%>/addCustomer">Add</a>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${customers != null}">
			<h3>List of Customers</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>firstName</th>
						<th>lastName</th>
						<th>email</th>
						<th>phoneNumber</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${customers}">
						<tr>
							<td>${c.id}</td>
							<td>${c.firstName}</td>
							<td>${c.lastName}</td>
							<td>${c.email}</td>
							<td>${c.phoneNumber }</td>

							<td><a href="<%=request.getContextPath()%>/customer/${c.id}">Details</a>
								&nbsp; &nbsp; <a
								href="<%=request.getContextPath()%>/delete/customer/${c.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No User found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>