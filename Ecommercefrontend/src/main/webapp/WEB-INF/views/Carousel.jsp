<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Midas Touch Carousel</title>
</head>
<body>
	<div class="container-fluid">

		<div class="carousel slide" id="myCarousel" data-ride="carousel">

			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
				<li data-target="#myCarousel" data-slide-to="5"></li>
			</ol>

			<div class="carousel-inner">
				<div class="item active">
					<a href=""> <img
						src="<c:url value="/resources/images/img1.jpg" />" alt="Image 1"
						style="width: 100%; height: 500px;">
					</a>

				</div>
				<div class="item">
					<a href=""> <img
						src="<c:url value="/resources/images/img2.jpg" />" alt="Image 2"
						style="width: 100%; height: 500px;">
					</a>
				</div>
				<div class="item">
					<a href=""> <img
						src="<c:url value="/resources/images/img3.jpg" />" alt="Image 2"
						style="width: 100%; height: 500px;">
					</a>
				</div>

				
				<div class="item">
					<a href=""> <img
						src="<c:url value="/resources/images/img4.jpg" />" alt="Image 5"
						style="width: 100%; height: 500px;">
					</a>
				</div>


			</div>

			<a href="#myCarousel" data-slide="prev" class="left carousel-control">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a> <a href="#myCarousel" data-slide="next"
				class="right carousel-control"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>

		</div>
	</div>
	</div>
</body>
</html>