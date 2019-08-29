<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>403 Access Denied</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="/homepage">Back</a></li>
		</ul>
	</nav>
	<div style=" position:fixed;top: 50%;left: 50%;transform: translate(-50%, -50%);color:red;font-size: 150%;">
		<p style="text-align:center">${name}</p> 
		<p style="text-align:center">You are not authorized to this page</p>
	</div>	
	
</body>
</html>
