<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ELECTRICITY BILLING SYSTEM | PAYMENT DETAILS</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.container {
	margin-top: 50px;
}

.card {
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.book_now {
	display: inline-block;
	padding: 10px 20px;
	font-size: 18px;
	font-weight: bold;
	text-decoration: none;
	color: #fff;
	background-color: #007bff;
	border-radius: 5px;
}
</style>
</head>

<body>
	<div class="container">
		<div class="card">
			<h3>Username: ${sessionScope.username}</h3>
			<h3>Consumer Number: ${sessionScope.consumerNumber}</h3>
			<h3>Meter Number: ${sessionScope.meterNumber}</h3>
			<h3>Previous Reading: ${sessionScope.previousReading}</h3>
			<h3>Current Reading: ${sessionScope.currentReading}</h3>
			<p>Amount you are required to pay: ${sessionScope.amount}</p>
			<br> <br> <a class="book_now"
				href="<%=request.getContextPath()%>/payment">Pay
				${sessionScope.amount}</a>
		</div>
	</div>
</body>

</html>
