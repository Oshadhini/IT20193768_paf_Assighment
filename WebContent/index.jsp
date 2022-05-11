<%@page import="com.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery.min.js"></script>
<script src="Components/employee.js"></script>
<script src="Components/jquery.min.js"></script>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<div class="row">
		<div class="col-lg-12">
			<div class="card m-b-32">
				<div class="card-body">

					<form id="formUser" name="formUser" method="post"
						action="index.jsp">

						<label>First Name</label> <input id="first_name"
							name="first_name" type="text"
							class="form-control form-control-sm">
							<br> 
							<label>Last Name</label><input id="last_name"
							name="last_name" type="text"
							class="form-control form-control-sm">
						
							<br><label>Email</label> <input id="email" name="email"
							type="text" class="form-control form-control-sm"> 
							
							<br><label>User Role</label>
							<select id="user_role" name="user_role" class="form-control form-control-sm">
							<option value="admin">admin</option>
							<option value="Manager">Manager</option>
							<option value="SeniorEngineer">Senior Engineer</option>
							<option value="Engineer">Engineer</option>
							<option value="Associate">Associate</option>
							<option value="Trainee">Trainee</option>
							</select>

							<br><label> Password</label> <input id="password"
							name="password" type="text"
							class="form-control form-control-sm">
							
							 <br>
							 <input id="btnSave" name="btnSave" type="button" value="Save"
							class="btn btn-primary"> <input type="hidden"
							id="hididSave" name="hididSave" value="">
					</form>
					<br>
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br> <br>
					
					<div id="divUserGrid">
						<%
						Employee empObj = new Employee();
											out.print(empObj.readEmployees());
						%>
					</div>
				</div>
</div>
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>