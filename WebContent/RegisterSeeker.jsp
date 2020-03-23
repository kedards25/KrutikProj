<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seeker Registration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  	<style type="text/css">
  		
  	</style>
</head>
<body>
<form action="RegisterSeekerVerify" method="post">
<div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
<h1><center>Register</center></h1>
    	<p><center>Please fill in this form to create an account.</center></p>
    	<hr>
	   	<label for="fname"><b>First Name:</b></label>
	<input type="text" placeholder="Enter first name" name="fname" required class="form-control"><br>

		<label for="lname"><b>Last Name:</b></label>
		<input type="text" placeholder="Enter last name" name="lname" required class="form-control"><br>

		<label for="age"><b>Age:</b></label>
		<input type="text" placeholder="Enter age" name="age" required class="form-control"><br>

 	
    	<label for="email"><b>Email:</b></label>
    	<input type="text" placeholder="Enter Email" name="email" required class="form-control"><br>

    	<label for="password"><b>Password:</b></label>
    	<input type="password" placeholder="Enter Password" name="password" required class="form-control"><br>

    	<label for="confirmpassword"><b>Confirm Password:</b></label>
    	<input type="password" placeholder="Repeat Password" name="confirmpassword" required class="form-control"><br>
		<center><button type="submit" class="btn btn-outline-secondary">Register</button></center>
		</div>
		</div>
		</div>
</div>

</form>
</body>
</html>