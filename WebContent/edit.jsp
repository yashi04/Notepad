<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/default.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="index.html">Home</a>
			</li>
		</ul>
	</nav>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="card col-sm-6">
				<div class="card-body">
					<form action="update" method="post">
						<input type="hidden" name="id" id="id"
							value="<c:out value="${country.id}"/>">
						<div class="form-group">
							<label for="country">Country:</label> <input type="text" name="country"
								class="form-control" placeholder="Enter your country" id="country"
								value="<c:out value="${country.country}"/>">
									</div>
									<button type="submit" class="btn btn-primary" value="Update">Update</button>
					</form>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>