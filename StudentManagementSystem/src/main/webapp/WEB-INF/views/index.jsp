<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>


<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Student Management System</title>
<style type="text/css">
body {
	background: #eba !important;
}
</style>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">

				<h1 class="text-center mb-3">Welcome to Student Mangement App</h1>
				<table class="table table-light table-bordered" id="student-table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">S.No</th>
							<th scope="col">Student Name</th>
							<th scope="col">Email</th>
							<th scope="col">Phone Number</th>
							<th scope="col">Age</th>
							<th scope="col">Address</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${students}" var="student">
							<tr>
								<th scope="row">${student.id}</th>
								<td>${student.name}</td>
								<td>${student.email}</td>
								<td>${student.phoneNumber}</td>
								<td>${student.age}</td>
								<td>${student.address}</td>

								<td><a href="update/${student.id}"> <i
										class="fas fa-user-edit text-primary mr-3 ml-2" style="font-size: 30px;"></i>
								</a> <a href="delete/${student.id}"> <i
										class="fas fa-trash text-danger" style="font-size: 30px;"></i></a></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>


				<div class="container  text-center ">
					<a href="add-student" class="btn btn-outline-success bg-success text-white">Add New
						Student</a>


				</div>

			</div>



		</div>



	</div>


	
</body>
<script type="text/javascript">
    $(document).ready(function() {
    	
        $.noConflict();
     var table = $("#student-table").DataTable({
    	 "searching":true,
    	 "autoWidth":true,
    	 "paging":true,
    	 "ordering":true
     });
    });
</script>
</html>