<%@page import="com.jobportal.project.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Profile Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="E:\Desktop\fontawesome-free-5.11.2-web\js\all.js"></script>
  	<style>
	body
	{
		background-color: #E7EEEC;
	}
  .input-group { width:100%;}
  
	.profile-head { width:100%;background-color: rgb(165, 190, 193);float: left;padding: 15px 5px;border-radius: 30px;}
  .profile-head img { height:180px; width:180px; margin:0 auto; border:5px solid #fff; border-radius:5px;}
  .profile-head h5 {width: 100%;padding:5px 5px 0px 5px;text-align:justify;font-weight: bold;color: #fff;font-size: 25px;text-transform:capitalize;
      margin-bottom: 0;}
  .profile-head p {width: 100%;text-align: justify;padding:0px 5px 5px 5px;color: #fff;font-size:17px;text-transform:capitalize;margin:0;}
  .profile-head a {width: 100%;text-align: center;padding: 10px 5px;color: #fff;font-size: 15px;text-transform: capitalize;}
  .profile-head ul {list-style:none;padding: 0;}
  .profile-head ul li {display:block; padding:5px;font-weight: 400;font-size: 15px;}
  .profile-head ul li:hover span { color:rgb(0, 4, 51);}
  .profile-head ul li span { padding-right: 10px;}
  
  .profile-head h6 {width: 100%;text-align: center;font-weight: 100;font-size: 15px;text-transform: uppercase;margin-bottom: 0;}
  .uplod-picture {width: 100%; padding:20px 10px;margin-bottom:10px;}
  .uplod-file {position: relative;overflow: hidden;color: #fff;background-color: rgb(0, 4, 51);border: 0px solid #a02e09;border-radius: 0px;
    transition:all ease 0.3s;margin: 5px;}
  .uplod-file input[type=file] {position: absolute;top: 0;right: 0;min-width: 100%;min-height: 100%;font-size: 100px;text-align: right;
    filter: alpha(opacity=0);opacity: 0;outline: none;background: white;cursor: inherit;display: block;}
  .uplod-file:hover, .uplod-file:focus {color: #fff;background-color:rgb(255, 102, 0);}
	
  .savebtn
  {
    margin-top: 20px;
    margin-left: 350px;
    border-radius: 2px solid black;

  }

  .savebtn1
  {
    margin-top: 20px;
  }

  .profile
  {
    height:100px;
    margin-top: 20px;
  }


  .profile-head
  {
    margin-bottom: 30px;
  }



</style>
</head>
<body>
<%
	Model model=(Model)request.getAttribute("modelObj");
%>
<jsp:include page="NavBar.jsp"></jsp:include>
<form action="Profile" method="post">
	<div class="container">

	<div class="home">
		
  <div class="profile-head">
        <div class="col-md- col-sm-4 col-xs-12">
            <img src="http://www.newlifefamilychiropractic.net/wp-content/uploads/2014/07/300x300.gif" class="img-responsive"/>
            
            <div class="container" style="margin-right: 120px;">
                <span class="btn btn-default uplod-file">
                        Upload Photo <input type="file" />
                </span>
            </div>
            
        </div>
  </div>
    <div class="profile">
      <div class="card" style="width: 18rem ;">
      <div class="card-body">
    <h5 class="card-title">Resume</h5>
    <a href="#" class="btn btn-primary">Add Resume</a>
  </div>
</div>
     <button type="button" class="btn btn-outline-primary btn-lg" style="margin-left: 700px;">Edit</button>   
     <div class="form-group col-md-6">
          <label for="fname"><b>First Name:</b></label>
          <input type="text" class="form-control" name="fname" value="<%=model.getFname() %>" readonly="readonly" required>
        </div>
        <div class="form-group col-md-6">
          <label for="lname"><b>Last Name:</b></label>
          <input type="text" class="form-control" name="lname" value="<%=model.getLname() %>" readonly="readonly" required>
        </div>
        <div class="form-group col-md-6">
          <label for="email"><b>Email Id:</b></label>
          <input type="text" class="form-control" name="email" value="<%=model.getEmail() %>" readonly="readonly" placeholder="Apartment, studio, or floor" required>
        </div>    
        <div class="form-group col-md-6">
          <label for="inputAddress"><b>Address:</b></label>
          <input type="text" class="form-control" name="inputAddress" placeholder="1234 Main St" required>
        </div>
  <!-- Default input -->
        
  <!-- Grid row -->
        <div class="form-row">
        <!-- Default input -->
        
          <div class="form-group col-md-6">
            <label for="inputCity"><b>City:</b></label>
            <input type="text" class="form-control" name="inputCity" placeholder="New York City" required>
          </div>
    <!-- Default input -->
          <div class="form-group col-md-6">
            <label for="inputZip"><b>Zip:</b></label>
            <input type="text" class="form-control" name="inputZip" placeholder="11206-1117" required>
          </div>
        <div class="col-md-6">
          <label for="qualification"><b>Qualification:</b></label>
          <select class="form-control" id="qualification" name="qualification" required class="form-control">
            <option>BScIT</option>
            <option>Computer Science</option>
            <option>Engineering</option>
          </select>
        </div>
        <div class="form-group col-md-6">
          <label for=" certificate"><b>Extra Certificates</b></label>
          <input type="text" class="form-control" name="certificate">
        </div>
        <div class="col-md-6">
          <label for="experience"><b>Experience:</b></label>
          <input type="text" name="experience" placeholder="Enter your experience if any" class="form-control">
        </div>
        <div class="col-md-6">
          <label for="cmpname"><b>Company Name:</b></label>
          <input type="text" name="cmpname" placeholder="If any experience enter Company's name" class="form-control">
        </div>
        <div class="col-md-6">
          <label for="tenmarks"><b>10th Marks:</b></label>
          <input type="number" name="tenmarks" placeholder="Enter Your 10th marks in percentage" class="form-control">
        </div>
        <div class="col-md-6">
          <label for="tmarks"><b>12th Marks:</b></label>
          <input type="number" name="tmarks" placeholder="Enter Your 12th marks in percentage" class="form-control">
        </div>
        <div class="col-md-6">
          <label for="hobbies"><b>Hobbies:</b></label>
          <input type="text" name="hobbies" placeholder="Enter your hobbies" required class="form-control">
        </div>
        <div class="col-md-6">
          <label for="bgroup"><b>Blood Group:</b></label>
          <input type="text" name="bgroup" placeholder="Enter your blood group" class="form-control">
        </div>
        <div class="col-md-6">
          <label for="cnumber"><b>Contact Number:</b></label>
          <input type="text" name="cnumber" placeholder="Enter contact number" required class="form-control">
        </div>
        <br><br>
        <div class="col-md-6">
             <div class="pull-right">
              <button type="submit" class=" btn btn-primary btn-lg savebtn">Save</button>
              <button type="submit" class="btn btn-warning  btn-lg savebtn1">Cancel</button>
            </div>
        </div>
      </div>

    </div>
</div>
</div>
</form>
</body>
</html>