<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Your Account</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="/SignOut">Logout</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/Admin">Admin</a>
			</li>
			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="" id="navbardrop"
				data-toggle="dropdown">Account & List</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="/account">Your Account</a> <a
						class="dropdown-item" href="#">Your Order</a>
				</div></li>
		</ul>
	</nav>
	<br>
<div class="container-wrapper">
    	<div class="container">
    		<div class="page-header">
    			<br><h1>Login and Security</h1>     
    			<table class="table table-striped table-hover">
           
            <thead>
            <tr class="bg-success">
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone</th>
                <th>Email</th>
            </tr>
            </thead>
           <%--  <c:forEach items="${user}" var="user"> --%>
                <tr>
                    <td>${fname}</td>
                    <td>${lname}</td>
                    <td>${phone}</td>
                    <td>${email}</td>
                </tr>
            <%-- </c:forEach> --%>
        </table>
	</div>
	</div>
	</div>
	</body>
</html>