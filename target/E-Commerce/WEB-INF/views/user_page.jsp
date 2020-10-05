<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>E-Commerce</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src='https://kit.fontawesome.com/a076d05399.js'></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
 
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="/SignOut">Logout</a>
			</li>
			<li class="nav-item">
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a class="nav-link" href="/Admin">Admin</a>
				</sec:authorize>
			</li>
			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="" id="navbardrop"
				data-toggle="dropdown">Account & List</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="/account">Your Account</a>
					<a class="dropdown-item" href="#">Your Order</a>
				</div>
			</li>
			<li><c:if test="${pageContext.request.userPrincipal.name != null}">
				<li style="font-size:35px;text-align:left;color:white;"><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
			</c:if>
			</li>
			<li class="nav-item"><a class="nav-link" href="/cart/getCartId/${cartId}">
				<i class='fas fa-cart-plus' style='font-size:30px;color:black;text-align:right;'></i></a>
			</li>
		</ul>
	</nav>
	<br>
<div class="container-wrapper">
    	<div class="container">
    		<div class="page-header">
    			<br><h1>All products List</h1>
    			<table class="table table-striped table-hover">
           
            <thead>
            <tr class="bg-success">
                <th>Product Name</th>
                <th>Category</th>
                <th>Description</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productDescription}</td>
                    <td>${product.productPrice} USD</td>
                   	<%-- <td><a href="getProductById/${product.productId}" class="btn btn-info"
						role="button">Add</a> --%>
                    
                    <td><a class="nav-link" href="/addToCart/${product.productId}">Add To Cart</a></td>
                </tr>
            </c:forEach>
        </table>
	</div>
	</div>
	</div>
	</body>
</html>