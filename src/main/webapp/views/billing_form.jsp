<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ELECTRICITY BILLING SYSTEM | Billing form</title>
<style>
.alert {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
}

.alert-success {
	color: #3c763d;
	background-color: #dff0d8;
	border-color: #d6e9c6;
}

.alert-danger {
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
</style>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<body>
	<div id="messages" class="alert-success">
		<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	</div>

	<script>
		setTimeout(function() {
			var messages = document.getElementById("messages");
			if (messages) {
				messages.style.display = 'none';
			}
		}, 3000);
	</script>
	<section class="vh-100 bg-image"
		style="background-color: rgb(0, 0, 77);">
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-5">
								<h2 class="text-uppercase text-center mb-5">Generate Your
									Bill</h2>
								<form method="POST" name="pay_bill_form"
									action="<%=request.getContextPath()%>/generateBill">

									<div class="form-outline mb-4">
										<input type="hidden" value="${customer.username}"
											name="username" id="username"
											class="form-control form-control-lg" />
									</div>

									<div class="form-outline mb-4">
										<input type="hidden" value="${customer.consumerNumber}"
											name="consumerNumber" id="consumerNumber"
											class="form-control form-control-lg" />
									</div>


									<div class="form-outline mb-4">
										<input type="text" value="${meter_number}" name="meter_number"
											id="meter_number" class="form-control form-control-lg" /> <label
											class="form-label" for="meter_number">Meter Number</label>
									</div>



									<div class="d-flex justify-content-center">
										<input type="submit" class="buttonclass" value="Generate Bill"
											style="background-color: blue; color: white; border-radius: 5px; padding: 10px;">
									</div>

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