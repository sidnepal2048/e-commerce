<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
				<li><c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li style="font-size:35px;text-align:left;color:white;"><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                            </c:if>
                          </li>
                          <li class="nav-item"><a class="nav-link" href="/cart/getCartId/${cartId}">
							<i class='fas fa-cart-plus' style='font-size:30px;color:black;text-align:right;'></i>
                         </a>
			</li>
		</ul>
	</nav>

		<div class="container"
		style="width: 1145px; margin-top: 20px; margin-bottom: 180px;">
		<div style="margin-bottom: 30px">
			<div>
				<br> List of Product Purchased
				<div>

					<a class="btn btn-danger pull-left"
						style="margin-top: 15px; margin-left: 20px" href="/cart/removeAllItem/${cartId}">Clear Cart
					</a>
				</div>
				<div>
					<c:url value="/order/${cartId}" var="url1"></c:url>
					<a href="${url1}" class="btn btn-danger pull-left"
						style="margin-top: 15px; margin-left: 20px"> <span
						class="glyphicon glyphicon-shipping-cart"> </span>Check Out
					</a>
				</div>
				<table class="table table-hover" id="productList">
					<thead>
						<tr>
							<th>Product Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Total Price</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${cartItem}" var="temp">
					
						<tr>
							<td>${temp.getProduct().getProductName()}</td>
							<td>${temp.getQuality()}</td>
							<td>${temp.getProduct().getProductPrice()}</td>
							<td>${temp.getPrice()}</td>
							<td><a href="/cart/removeCartItem/${cartItemId}" class="btn btn-danger"
								style="margin-top: 0px;"><span
									class="glyphicon glyphicon-trash"></span>remove</a></td>
                </c:forEach>
					
					</tbody>
				</table>
				<p style="text-align:center;">Grand Total Price: ${price}</p>
			</div>
			<c:url value="/homepage" var="url"></c:url>
			<a href="${url}" class="btn btn-default" style="margin-left: 20px">Continue
				Shopping</a>
		</div>
	</div>
	
</body>
</html>