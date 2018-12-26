<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyCart</title>
</head>
<body>
	<div class="container">

		<div id="viewCart">
			
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<div class="h3">My Cart</span></div>
					</div>
					<div class="col-md-4">
						<td><a href="myCart-deleteAll/${cart.user_id}" class="btn btn-danger">Remove All Products</a></td>
					</div>
				</div>
			</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Product</td>
						<td>Date Added</td>
						<td>Quantity</td>
						<td>Price (Rs)</td>
						<td>Action</td>
					</tr>
				</thead>
				<c:forEach var="cart" items="${cartList}">
					<tr>
						<td>${cart.product_name}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${cart.date_added}" /></td>
						<td>
								<input type="number" id="quant" value="${cart.quantity}"/>						
						<!-- <form class="form-horizontal" action="myCart-quant/${cart.id}" method="get">
	 							<div class="form-group">
							        <input type="number" id="quant" value="${cart.quantity}"/>
							    </div>
							    <div class="form-group">
							        <button type="submit"><i class="fa fa-refresh" aria-hidden="true"></i></button>
    							</div>
    						</form> -->
    					</td>
						<td>${cart.price}</td>
						<td><a href="myCart-delete/${cart.id}" class="btn btn-danger">Remove</a></td>
					</tr>
				</c:forEach>
				<hr />
				<tr>
					<td><a href="Home" class="btn btn-warning">Continue Shopping</a></td>
					<td></td>
					<td>Total Rs. ${totalAmount}</td>
					<td><a href="myCart-checkOut/${cart.user_id}" class="btn btn-success">Check Out</a></td>
				</tr>

			</table>
		</div>
	</div>
</body>
</html>