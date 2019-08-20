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
	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Register user</h1>

				<p class="lead">Please fill in your information below:</p>
			</div>

			<form:form action="${pageContext.request.contextPath}/login"
				method="post" commandName="user">

				<h3>Enter email and password</h3>

				<div class="form-group">
					<label for="email">Email</label>
					<form:input path="email" id="email"
						class="form-Control" />
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<form:input path="password" id="password"
						class="form-Control" />
				</div>
				
			

				<input type="submit" value="submit" class="btn btn-default">
				<a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
			</form:form>
		</div>
	</div>

</body>
</html>