<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Register Customer</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="/">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/register">Register</a>
			</li>
			<li class="nav-item">
      			<a class="nav-link" href="/login">Login</a>
    		</li>
    		<li class="nav-item">
      <a class="nav-link" href="/about">About</a>
    </li>
		</ul>
	</nav>
	      
	<h3 class="mb-3" style="text-align: center;">Register User</h3>
<div id="container">
	<form:form id="inputForm" action="${pageContext.request.contextPath}/register"
			   class="needs-validation" method="post" commandName="user" novalidate="false">
		<div class="row ml-2 mr-2 border-blue-bottom">
				<div class="col-6">
					<h6>Personal Information</h6>
					<div class="form-group row">
						<label for="fname" class="col-md-4 col-form-label required">First Name:</label>
						<div class="col-md-5">
							<form:input path="fname" id="fname" name="fname" class="form-Control" required="required" />
							<div class="invalid-feedback">Missing required field</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="lname" class="col-md-4 col-form-label required">Last Name:</label>
						<div class="col-md-5">
							<form:input path="lname" id="lname" name="lname" class="form-Control" required="required" />
						</div>
					</div>
					<div class="form-group row">
						<label for="phone" class="col-md-4 col-form-label required">Phone No.:</label>
						<div class="col-md-5">
							<form:input path="phone" id="phone" class="form-Control" required="required" />
						</div>
					</div>
					<div class="form-group row">
						<label for="email" class="col-md-4 col-form-label required">Email:</label>
						<div class="col-md-5">
							<form:input path="email" id="email" class="form-Control" required="required" />
						</div>
					</div>
					<div class="form-group row">
						<label for="password" class="col-md-4 col-form-label required">Password:</label>
						<div class="col-md-5">
							<form:input path="password" id="password" class="form-Control" required="required" />
						</div>
					</div>
				</div>
		</div>
	<div class="row ml-2 mr-2 mt-2">
		<div class="col border-blue-right">
			<h6>Billing Address</h6>
			<div class="form-group row">
				<label for="billingAddress.address" class="col-md-4 col-form-label required">Address:</label>
				<div class="col-md-5">
					<form:input path="billingAddress.address" id="billingAddress.address" class="form-Control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingAddress.city" class="col-md-4 col-form-label required">City:</label>
				<div class="col-md-5">
					<form:input path="billingAddress.city" id="billingAddress.city" class="form-Control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingAddress.state" class="col-md-4 col-form-label required">State:</label>
				<div class="col-md-5">
					<form:input path="billingAddress.state" id="billingAddress.state" class="form-Control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingAddress.country" class="col-md-4 col-form-label required">Country:</label>
				<div class="col-md-5">
					<form:input path="billingAddress.country" id="billingAddress.country" class="form-Control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingAddress.zip" class="col-md-4 col-form-label required">Zip:</label>
				<div class="col-md-5">
					<form:input path="billingAddress.zip" id="billingAddress.zip" class="form-Control" required="required" />
				</div>
			</div>
		</div>

		<div class="col">
			<h6>Shipping Address</h6>
			<div class="form-group row">
				<label for="shippingAddress.address" class="col-md-4 col-form-label required">Address:</label>
				<div class="col-md-5">
					<form:input path="shippingAddress.address" id="shippingAddress.address" class="form-Control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label for="shippingAddress.city" class="col-md-4 col-form-label required">City:</label>
				<div class="col-md-5">
					<form:input path="shippingAddress.city" id="shippingAddress.city" class="form-Control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label for="shippingAddress.state" class="col-md-4 col-form-label required">State:</label>
				<div class="col-md-5">
					<form:input path="shippingAddress.state" id="shippingAddress.state" class="form-Control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label for="shippingAddress.country" class="col-md-4 col-form-label required">Country:</label>
				<div class="col-md-5">
					<form:input path="shippingAddress.country" id="shippingAddress.country" class="form-Control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label for="shippingAddress.zip" class="col-md-4 col-form-label required">Zip:</label>
				<div class="col-md-5">
					<form:input path="shippingAddress.zip" id="shippingAddress.zip" class="form-Control" required="required" />
				</div>
			</div>
		</div>
	</div>
	</form:form>
	<div class="row">
		<div class="col-md-6 ml-4">
			<button form="inputForm" class="btn cc-btn" type="submit">Register</button>
			<a href="<c:url value="/" />" class="btn cc-btn">Cancel</a>
		</div>
	</div>
</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</body>
</html>