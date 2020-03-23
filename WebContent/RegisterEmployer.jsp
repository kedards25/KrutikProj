<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration of Employer</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  	<style type="text/css">
  		.card-body
		{
			background-color:#E7EEEC;
		}
  	</style>
</head>
<body>
<form action="RegisterEmpVerify" method="post">
<div class="container">
<!--  <h1><center>Register</center></h1>
    	<p><center>Please fill in this form to create an account.</center></p>
    	<hr>
    	<div class = "form-row">
         	<div class = "form-group col-md-6">-->
	<div class="row">
    	<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        	<div class="card card-signin my-5">
          		<div class="card-body">
            	<h3 class="card-title text-center">Sign Up</h3>
            	<p><center>Please fill in this form to create an account.</center></p>
         		<div class="form-label-group">
	   				<label for="fname"><b>First Name</b></label>
					<input type="text" placeholder="Enter first name" name="fname" required class="form-control"><br>
				</div>
		
               <div class="form-label-group">
					<label for="lname"><b>Last Name</b></label>
					<input type="text" placeholder="Enter last name" name="lname" required class="form-control"><br>
				</div>
				
               <div class="form-label-group">
					<label for="age"><b>Age</b></label>
					<input type="text" placeholder="Enter age" name="age" required class="form-control"><br>
				</div>
			
 				<div class="form-label-group">
    				<label for="email"><b>Email</b></label>
    				<input type="text" placeholder="Enter Email" name="email" required class="form-control"><br>
				</div>
				
               <div class="form-label-group">
    				<label for="password"><b>Password</b></label>
    				<input type="password" placeholder="Enter Password" name="password" required class="form-control"><br>
    			</div>
			
        	<div class="form-label-group">
    			<label for="confirmpassword"><b>Repeat Password</b></label>
    			<input type="password" placeholder="Repeat Password" name="confirmpassword" required class="form-control"><br>
    		</div>
    	
            <div class="form-label-group">
				<label for="comapny_name"><b>Company Name:</b></label>
				<input type="text" placeholder="Enter company name" name="comapny_name" required class="form-control"><br>
			</div>
			
            <div class="form-label-group">
				<label for="contactno"><b>Company Number:</b></label>
				<input type="text" placeholder="Enter number of the Company" name="contactno" required class="form-control"><br>
			</div>

		<input type="submit">
	</div>
	</div>
	</div>
	</div>
</div>
</form>
</body>
</html>