<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<style type="text/css">
.navbar-custom {
    color: #FFFFFF;
    background-color: #304FFE;
}
.navbar{
border-radius:0px;
}
</style>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Midas Touch Header</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top navbar-custom" id="my-navbar">
		<div class="container-fluid">
			<div class="navbar-header ">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a href="Home" class="navbar-brand">
					<img src="<c:url value="/resources/images/MidasTouch.jpg" />" alt="logo" style="max-height: 50px; margin-top: -15px;margin-left: -15px;">
				</a>
			</div>
		
			<div class="collapse navbar-collapse" id="navbar-collapse">
				
				<ul class="nav navbar-nav navbar-pills">
				<li class="nav-item">
						<a href="Home" ><i class="fa fa-home fa-lg" aria-hidden="true"></i> Home</a>
					</li>
				</ul>
				
				<ul class="nav navbar-nav navbar-right nav-pills">
					<c:if test="${isUserLoggedIn=='true'}"> 
						<li><a href="userInfo"><i class="fa fa-user" aria-hidden="true"></i> ${Username}</a></li>
						<li><a href="myCart"><i class="fa fa-shopping-cart" aria-hidden="true"></i> My Cart <span class="label label-info">${cartSize}</span></a></li>
						<li><a href="secure_logout"><i class="fa fa-sign-out" aria-hidden="true"></i> Log Out </a></li>

					</c:if>
					<c:if test="${isAdmin=='true'}">
						<li><a href="<c:url value="secure_logout" />"><i class="fa fa-sign-out" aria-hidden="true"></i> Log Out </a></li>

					</c:if>
					<c:if test="${!isUserLoggedIn=='true' && !isAdmin =='true'}">
						<li><a href="RegistrationPage"><i class="fa fa-user-plus" aria-hidden="true"></i> SignUp </a></li>
						<li><a href="Login"><i class="fa fa-sign-in" aria-hidden="true"></i> Login </a></li>
					</c:if>


				</ul>



				<ul class="nav navbar-nav nav-pills">
				

					<!-- Dropdown of category -->
					<li class="dropdown"><a href=""><i class="fa fa-list" aria-hidden="true"></i> Categories<span class="caret"></span></a>
					<ul class="dropdown-menu scrollable-menu" role="menu">
					<c:forEach var="category" items="${categoryList}">
						<li class="dropdown-header"><a href="showProductByCategory/${category.id}"> ${category.name}</a></li>
								<li class="divider"></li>
								<c:forEach var="product" items="${productList}">
									<c:if test="${product.category_id == category.id}">
										<li><a role="menuitem" href="viewProduct/${product.id}">${product.name}</a></li>
									</c:if>
									
								</c:forEach>
							<li class="divider"></li>
					</c:forEach>
					</ul>
					</li>

					<li><a href="ContactUs"><i class="fa fa-phone fa-lg" aria-hidden="true"></i> Contact Us </a></li>

				</ul>
			</div>
		</div>
	</nav>




</body>
</html>