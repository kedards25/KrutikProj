<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
	.card-body
	{
		-webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  		box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
		background-color:#E7EEEC;
	}
</style>
</head>
<body>
	<form action="AdminVerifyServlet" method="post">
	<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h3 class="card-title text-center">Sign In</h3>
            
              <div class="form-label-group">
              	<label for="email"><b>Email address</b></label>
                <input type="text" name="email" class="form-control" placeholder="Email address" required autofocus>
              </div>

              <div class="form-label-group">
              	<label for="password"><b>Password</b></label>
                <input type="password" name="password" class="form-control" placeholder="Password" required>
              </div>

              <!-- <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1">
                <label class="custom-control-label" for="customCheck1">Remember password</label>
              </div> -->
              <br>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
          </div>
      </div>
  </div>
</div>
</div>
</form>
</body>
</html>