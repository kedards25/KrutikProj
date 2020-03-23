<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Jobs</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <style>
  	.container
  	{
  		background-color: #E7EEE7;
  	}
  </style>
</head>
<body>

<%
	HttpSession session1=request.getSession(false);
	if(session.getAttribute("empid")!=null)
	{
		String value=session1.getAttribute("empid").toString();	
	
%>
<jsp:include page="NavBar.jsp"></jsp:include>
<form action="JobVerify" method="post">
<div class="container col-md-3">

<h3><center><b>Add Jobs</b></center></h3>
	<label for="jobdescription">Job Description:</label>
	<input type="text" name="jobdescription" placeholder="Description of the job" required class="form-control">
	<label for="jobcriteria">Job Criteria:</label>
	<input type="text" name="jobcriteria" placeholder="Criteria of the Job" required class="form-control">
	<label for="salary">Salary:</label>
	<input type="text" name="salary" required class="form-control">
	<label for="location">Location:</label>
	<input type="text" name="location" required class="form-control">
	<br>
	<input type="submit" value="Add Jobs">
	
</div>
</form>
<%
	}
	else
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployerLogin.jsp");
		dispatcher.forward(request, response);
	}
%>
</body>
</html>