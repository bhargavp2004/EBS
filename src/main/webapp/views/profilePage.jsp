<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Candal&family=Montserrat:wght@400;500&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
body {
	background-image: url('/static/images/pexels-pixabay-258154.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	align-items: center;
	font-family: montserrat;
	text-align: center;
}

.username {
	position: absolute;
	top: 10px;
	right: 10px;
	color: white;
	font-size: 16px;
	display: inline-block;
}

.msgclass {
	color: white;
	background-color: rgba(0, 0, 77, 0.9);
}

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

a {
	text-decoration: none;
}

.userClass {
	color: white;
	font-family: Montserrat;
}

body {
	background-image: url('/images/MainPicture.jpg');
	/* background-image: url('/media/D/B.TECH/4TH SEMESTER/SEPP/HotelManagementSystem/static/images/pexels-pixabay-258154.jpg'); */
	background-size: cover;
	background-repeat: none;
	font-family: Arial, Helvetica, sans-serif;
	align-items: center;
}

.nav {
	list-style: none;
	margin-top: 80px;
	/* padding:0; */
	text-align: center;
}

.nav li {
	display: inline;
	opacity: 1.0;
}

.nav a {
	display: inline-block;
	padding: 20px;
	text-decoration: none;
	color: white;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 20px;
	font-weight: bold;
	text-shadow: 65px;
	transition: font-size 0.4s;
}
/* 
.nav:hover{
  font-size : 25px;
} */
.nav a:hover {
	font-size: 25px;
}

.image {
	background: rgba(0, 0, 77, 0.9); /*rgba(59, 59, 142, 0.5)*/
	padding: 50px;
	position: relative;
}

.image2 {
	background-image: url('/images/MainPicture.jpg');
	padding: 150px;
	width: 35px;
	text-align: center;
}

img {
	width: 150px;
	transition: width 0.5s;
}

.submitbutton {
	background-color: rgba(0, 0, 77, 0.9);
	padding: 10px;
	color: white;
	font-size: 18px;
	font-weight: bold;
	text-align: center;
	margin-top: 80px;
	border-radius: 5px;
	text-shadow: 65px;
	transition: font-size 0.4s;
}

.submitbutton:hover {
	font-size: 24px;
}

h1 {
	color: white;
	font-size: 50px;
	font-family: Candal;
	text-shadow: 65px;
}

p {
	color: black;
	font-family: Candal;
	text-shadow: 65px;
	font-size: 20px;
}

.col-1 {
	width: 8.33%;
}

.col-2 {
	width: 16.66%;
}

.col-3 {
	width: 25%;
}

.col-4 {
	width: 33.33%;
}

.col-5 {
	width: 41.66%;
}

.col-6 {
	width: 50%;
}

.col-7 {
	width: 58.33%;
}

.col-8 {
	width: 66.66%;
}

.col-9 {
	width: 75%;
}

.col-10 {
	width: 83.33%;
}

.col-11 {
	width: 91.66%;
}

.col-12 {
	width: 100%;
}

@media only screen and (max-width: 768px) {
	/* For mobile phones: */
	[class*="col-"] {
		width: 100%;
	}
}

.leftclass {
	float: left;
	color: white;
	margin-top: 390px;
	font-size: 18px;
	transition: font-size 0.4s;
}

.leftclass:hover {
	font-size: 25px;
}

/* .image:hover{

} */
.book_now {
	background-color: rgba(0, 0, 77, 0.9);
	padding: 10px;
	color: white;
	font-size: 18px;
	font-weight: bold;
	text-align: center;
	margin-top: 80px;
	border-radius: 5px;
	text-shadow: 65px;
	transition: font-size 0.4s;
	text-decoration: none;
}

.boxstyling {
	padding: 50px;
	background-color: rgba(0, 0, 77, 0.9);
	border-radius: 15px;
	border-color: black;
	align-items : left;
}
.innerstyle{
padding : 100px;
background-color : white;
align-items : left;
}

.box{
	padding : 50px;
	border-radius : 10px;
}

.meter-details {
	background-color: lightgray;
	padding: 20px;
	margin-bottom: 10px;
}

h4 {
	font-family : montserrat;
	margin-top: 0;
	margin-bottom: 5px;
}

.delete-btn {
	display: inline-block;
	padding: 5px 10px;
	background-color: rgba(0, 0, 77);
	color: #fff;
	text-decoration: none;
	border-radius: 4px;
}

.delete-btn:hover {
	background-color: black;
}

</style>

<body>
		<div class="boxstyling">
			<c:if test="${not empty list }">
			<c:forEach var = "t" items = "${list}">
			
			<div class="meter-details">
			<h4>Meter Number: ${t.getMeter_number()}</h4>
			<h4>Consumer Number: ${sessionScope.consumerNumber}</h4>
			<h4>Billing Rate: ${t.getBillingRate()} Rupees / kWh</h4>
			<h4>Current Reading: ${t.getCurrentReading()} kWh</h4>
			<h4>Previous Reading: ${t.getPreviousReading()} kWh</h4>
			<a class="delete-btn" href="<%=request.getContextPath()%>/delete/${t.getMeter_number()}">DELETE</a>
		</div>
			
			</c:forEach>
			</c:if>
		</div>
</body>

</html>
