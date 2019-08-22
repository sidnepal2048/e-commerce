<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>About</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
	      
	<h3 class="mb-3" style="text-align: center;">User Information</h3>
	<div class="bg-light">
		<div class="container">
			<form:form action="${pageContext.request.contextPath}/register" method="post" commandName="user">
				<br>
				
				<div class="row">
					<div class="col-md-6 mb-3">
					<label for="fname">First Name:</label>
					<%-- <form:errors path="customerName" cssStyle="color: #ff0000" /> --%>
					<form:input path="fname" id="fname" name="fname" class="form-Control" required="required" />
				</div>
				

				<div class="col-md-6 mb-3">
					<label for="lname">Last Name:</label>
					<form:input path="lname" id="lname" name="lname" class="form-Control" required="required" />
				</div>
				</div>
				
				<div class="mb-3">
					<label for="phone">Phone No.:</label>
					<div class="input-group">
					<form:input path="phone" id="phone" class="form-Control" required="required" />
					</div>
				</div>
				
				<div class="mb-3">
					<label for="phone">Email:</label>
					<div class="input-group">
					<form:input path="email" id="email" class="form-Control" required="required" />
					</div>
				</div>
				
				<div class="mb-3">
					<label for="password">Password:</label>
					<div class="input-group">
					<form:input path="password" id="password" class="form-Control" required="required" />
						</div>
				</div>
				
			
			<hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
				<a href="<c:url value="/" />" class="btn btn-primary btn-lg btn-block">Cancel</a>
			</form:form>
		</div>
	</div>

</body>
</html>