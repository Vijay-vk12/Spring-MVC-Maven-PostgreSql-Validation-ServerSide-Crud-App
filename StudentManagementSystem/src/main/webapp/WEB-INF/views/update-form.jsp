<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
<style type="text/css">
body {
	background: #eba !important;
}
</style>
</head>
<body>

	<c:if test="${not empty message}">
		<div class="col-sm-3 p1 mb-1 m-3 text-white fw-bold bg-danger">${message}</div>
	</c:if>
	<div class="container mt-3">

		<div class="row">


			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Update Student Details</h1>

				<form action="${pageContext.request.contextPath}/update"
					method="post">

					<input type="text" value="${student.id}" name="id" readonly />

					<div class="form-group">
						<label for="name">Student Name</label> <input type="text"
							class="form-control" id="name" aria-describedby="emailHelp"
							name="name" placeHolder="Enter the Student Name here"
							value="${student.name}">
					</div>

					<div class="form-group">
						<label for="email">Email</label> <input type="text"
							class="form-control" id="email" name="email"
							placeHolder="Enter Email" value="${student.email}" readonly>
					</div>

					<div class="form-group">
						<label for="phoneNumber">Phone Number</label> <input type="text"
							class="form-control" id="phoneNumber" name="phoneNumber"
							placeHolder="Enter Phone Number" value="${student.phoneNumber}" readonly>
					</div>


					<div class="form-group">
						<label for="age">Student Age</label> <input type="text"
							class="form-control" id="age" aria-describedby="emailHelp"
							name="age" placeHolder="Enter the Student Age here"
							value="${student.age}">
					</div>




					<div class="form-group">
						<label for="address">Address</label>
						<textarea rows="3" placeholder="Enter Address"
							class="form-control" name="address" id="address">${student.address}</textarea>
					</div>


					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-warning bg-warning text-white">Back</a>
						<button type="submit" class="btn btn-primary">Update</button>
					</div>


				</form>



			</div>
		</div>





	</div>



</body>
</html>