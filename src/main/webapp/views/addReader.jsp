<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Register Yourself</title>
<head>
<style>
</style>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<body>
	<h2>Register Yourself</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<section class="vh-100 bg-image"
		style="background-color: rgb(0, 0, 77);">
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-5">
								<h2 class="text-uppercase text-center mb-5">Create an
									account</h2>
								<form method="POST" name="add_customer"
									action="<%=request.getContextPath()%>/add/reader">

									<div class="form-outline mb-4">
										<input type="text" value="${firstName}" name="firstName"
											id="firstName" class="form-control form-control-lg" /> <label
											class="form-label" for="firstName">First name</label>
									</div>

									<div class="form-outline mb-4">
										<input type="text" value="${lastName}" name="lastName"
											id="lastName" class="form-control form-control-lg" /> <label
											class="form-label" for="lastName">Last name</label>
									</div>

									<div class="form-outline mb-4">
										<input type="text" value="${userName}" name="username"
											id="username" class="form-control form-control-lg" /> <label
											class="form-label" for="userusernameName">Username</label>
									</div>

									<div class="form-outline mb-4">
										<input type="password" value="${password}" name="password"
											id="password" class="form-control form-control-lg" /> <label
											class="form-label" for="password">password</label>
									</div>

									<div class="form-outline mb-4">
										<input type="email" value="${email}" name="email" id="email"
											class="form-control form-control-lg" /> <label
											class="form-label" for="email">Email</label>
									</div>

									<div class="form-outline mb-4">
										<input type="text" value="${phoneNumber}" name="phoneNumber"
											id="phoneNumber" class="form-control form-control-lg" /> <label
											class="form-label" for="phoneNumber">Phone number</label>
									</div>

									<div class="form-outline mb-4">
										<input type="text" value="${address}" name="address"
											id="address" class="form-control form-control-lg" /> <label
											class="form-label" for="address">Address</label>
									</div>

									<div class="form-outline mb-4">
										<input type="text" value="${city}" name="city" id="city"
											class="form-control form-control-lg" /> <label
											class="form-label" for="city">City</label>
									</div>


									<div class="form-outline mb-4">
										<input type="text" value="${state}" name="state" id="state"
											class="form-control form-control-lg" /> <label
											class="form-label" for="state">State</label>
									</div>

									<div class="d-flex justify-content-center">
										<input type="submit" class="buttonclass" value="Register"
											style="background-color: rgb(0, 0, 77); color: white; border-radius: 5px; padding: 10px;">
									</div>

									<p class="text-center text-muted mt-5 mb-0">
										Have already an account? <a href="#!"
											class="fw-bold text-body"><u>Login here</u></a>
									</p>

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>