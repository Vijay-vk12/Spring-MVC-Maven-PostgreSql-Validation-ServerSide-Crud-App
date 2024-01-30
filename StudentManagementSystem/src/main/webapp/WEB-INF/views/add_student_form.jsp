<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
<style type="text/css">
body {
	background: #eba !important;
}

.error {
	color: red
}

.error-message {
	color: #ff0000;
	font-size: 14px;
	margin-top: 5px;
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
				<h1 class="text-center mb-3">Student Registration Form</h1>
				<!-- form starts -->
				<form action="handle-student" method="post" modelAttribute="student">
					<div class="form-group">
						<label for="name">Student Name</label> <input type="text"
							class="form-control" id="name" aria-describedby="emailHelp"
							name="name" placeHolder="Enter the Student Name here" path="name"
							value="${student.name}" required="required">
						<c:forEach items="${fieldErrors}" var="fieldError">
							<c:if test="${fieldError.field == 'name'}">
								<div class="error-message">
									<p>${fieldError.defaultMessage}</p>
								</div>
							</c:if>
						</c:forEach>
					</div>


					<div class="form-group">
						<label for="email">Email</label> <input type="text"
							class="form-control" id="email" name="email" path="email"
							placeHolder="Enter Email" value="${student.email}"
							required="required">
						<c:forEach items="${fieldErrors}" var="fieldError">
							<c:if test="${fieldError.field == 'email'}">
								<div class="error-message">
									<p>${fieldError.defaultMessage}</p>
								</div>
							</c:if>
						</c:forEach>
						<c:if test="${not empty emailMessage}">
						<p class="error-message">${emailMessage}</p>
						</c:if>
						<div class="container mt-3"></div>




						<div class="form-group">
							<label for="phoneNumber">Phone Number</label> <input type="text"
								class="form-control" id="phoneNumber" name="phoneNumber"
								placeHolder="Enter Phone Number" value="${student.phoneNumber}"
								path="phoneNumber" required="required">
							<c:forEach items="${fieldErrors}" var="fieldError">
								<c:if test="${fieldError.field == 'phoneNumber'}">
									<div class="error-message">
										<p>${fieldError.defaultMessage}</p>
									</div>
								</c:if>
							</c:forEach>
							<c:if test="${not empty phoneMessage}">
							<p class="error-message">${phoneMessage}</p>
							</c:if>
							<div class="container mt-3"></div>


							<div class="form-group">
								<label for="age">Student Age</label> <input type="number"
									class="form-control" id="age" aria-describedby="emailHelp"
									name="age" placeHolder="Enter the Student Age here"
									aria-describedby="emailHelp" value="${student.age}">
								<c:forEach items="${fieldErrors}" var="fieldError">
									<c:if test="${fieldError.field == 'age'}">
										<div class="error-message">
											<p>${fieldError.defaultMessage}</p>
										</div>
									</c:if>
								</c:forEach>


							</div>




							<div class="form-group">
								<label for="address">Address</label>
								<textarea rows="3" placeholder="Enter Address"
									class="form-control" name="address" id="address" path="address">${student.address}</textarea>

							</div>


							<div class="container text-center">
								<a href="${pageContext.request.contextPath}/"
									class="btn btn-outline-danger bg-danger text-white">Back</a>
								<button type="submit" class="btn btn-primary">Add</button>
							</div>
				</form>



				<!-- form ends -->

			</div>

		</div>





	</div>

	<!-- 	<div class="col-sm-3 pt-3 mb-1 text-white">
				<c:if test="${not empty result.allErrors}">
					<ul class="error-list bg-danger pr-2">
						<p class="fw-bold ">Validation message:</p>
						<c:forEach items="${result.allErrors}" var="error">
							<li>${error.defaultMessage}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div> -->

</body>
</html>