<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Welcome</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>


</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="/">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/register">Register</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/login">Login</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/about">About</a>
			</li>
		</ul>
	</nav>
	<div class="container">
  <h2></h2>
  <div class="row">
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="${pageContext.request.contextPath}/resources/img/converse.jpg" target="_blank">
          <img src="<c:url value="/resources/img/converse.jpg"/>" alt="Lights" style="width:100%">
          <div class="caption">
            <p>Converse</p>
            <p>$80</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="${pageContext.request.contextPath}/resources/img/cover.jpg" target="_blank">
          <img src="<c:url value="/resources/img/cover.jpg"/>" alt="Lights" style="width:100%">
          <div class="caption">
            <p>cover</p>
            <p>$25.99</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="${pageContext.request.contextPath}/resources/img/hat.jpg" target="_blank">
        <img src="<c:url value="/resources/img/hat.jpg"/>" alt="Lights" style="width:100%">
          <div class="caption">
            <p>hat</p>
            <p>$10</p>
          </div>
        </a>
      </div>
    </div>
  </div>
</div>
	
</body>
</html>