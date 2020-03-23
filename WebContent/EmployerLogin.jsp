<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<style>
	body {
    margin: 0;
    padding: 0;
    font-family: sans-serif;
    background: linear-gradient(to right, #b92b27, #1565c0)
}

.box {
    width: 500px;
    padding: 40px;
    position: absolute;
    top: 50%;
    left: 50%;
    background: #191919;
    ;
    text-align: center;
    transition: 0.25s;
    margin-top: 100px
}

.box input[type="text"],
.box input[type="password"] {
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #3498db;
    padding: 10px 10px;
    width: 250px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s
}

.box h1 {
    color: white;
    text-transform: uppercase;
    font-weight: 500
}

.box input[type="text"]:focus,
.box input[type="password"]:focus {
    width: 300px;
    border-color: #2ecc71
}

.box input[type="submit"] {
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #2ecc71;
    padding: 14px 40px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s;
    cursor: pointer
}

.box input[type="submit"]:hover {
    background: #2ecc71
}

.forgot {
    text-decoration: underline
}


</style>
</head>
<body>
	<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <form class="box" action="LoginEmpVerify" method="post">
                    <h1>Login</h1>
                    <p class="text-muted"> Please enter your email and password!</p> 
                    <input type="text" name="email" placeholder="EmailId"> 
                    <input type="password" name="password" placeholder="Password"> 
                    <a class="forgot text-muted" href="#">Forgot password?</a> 
                    <input type="submit" name="" value="Login"> 
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
