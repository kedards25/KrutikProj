<%@page import="com.jobportal.project.ConnectionEmployer"%>
<%@page import="com.jobportal.project.EmployerModel"%>
<%@page import="com.jobportal.project.JobModel"%>
<%@page import="java.util.List"%>
<%@page import="com.jobportal.project.ConnectionModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply Job</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div id="res"></div>

<%
	HttpSession seekersession1 = null;
	seekersession1 = request.getSession(false);
	if (seekersession1.getAttribute("seekerEmail") != null) 
	{
		String value = seekersession1.getAttribute("seekerEmail").toString();
%>
<%
	ConnectionModel cm=new ConnectionModel();
	JobModel jmodel;
	ConnectionEmployer ce=new ConnectionEmployer();
	
	int jId=Integer.parseInt(request.getParameter("jobId"));
	jmodel=cm.viewJobById(jId);
	
	EmployerModel em=ce.viewEmployerById(jmodel.getEmployer_id());
	System.out.println(em);
%>
<jsp:include page="NavBar.jsp"></jsp:include>
<div class ="container">

<div class="card" style="width: 18rem;">
  <!--<img class="card-img-top" src="..." alt="Card image cap">-->
  <div class="card-body">
  
  <form action="AddApplicant">
    <label><b>Job Description:</b></label>
    	<p><%out.print(jmodel.getJobdescription());%></p>
    	
    <label><b>Job Location:</b></label>
    	<p><%out.println(jmodel.getLocation());%></p>
    	
    <label><b>Employer's Email Id:</b></label>
    	<p><%out.println(em.getEmail());%></p>
   
    <label><b>Contact Number:</b></label>
    	<p><%out.println(em.getContactno());%></p>
    
    <input type="submit" value="Apply">
     <a href="SeekerViewJobs.jsp"><button>Cancel</button></a>
    </form>
   
  </div>
</div>
</div>
<%
	}
		else 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("SeekerLogin.jsp");
			dispatcher.forward(request, response);
		}
%>
</body>
</html>