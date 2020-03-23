<%@page import="com.jobportal.project.AdminConModel"%>
<%@page import="com.jobportal.project.JobModel"%>
<%@page import="java.util.List"%>
<%@page import="com.jobportal.project.ConnectionEmployer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin View Jobs</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>

<%
	HttpSession adminsession=null;
	adminsession=request.getSession(false);
	
	if(adminsession.getAttribute("AdminUser")!=null)
	{
		//String value=adminsession.getAttribute("usertype").toString();
		%>
<jsp:include page="NavBar.jsp"></jsp:include>	

<div id="res"></div>
<%
	AdminConModel am=new AdminConModel();
	List<JobModel> viewJob=am.jobViewAll();
	 int i=1;
	if(viewJob.size()>0)
	{
%>
<div class ="container">
	<div align="right">
			<form method="post">
			<input type="submit"  value="Refresh List"/>
			<!-- <button type="button" class="btn btn-outline-info" type="submit">Refresh List</button>-->
			</form>
	</div><br/>
	<table class="table table-hover">
    	<thead class="thead-dark">
      	<tr>
      		<th>Job Id</th>
        	<th>Job Description</th>
        	<th>Job Criteria</th>
        	<th>Salary</th>
        	<th>Location</th>
        	<th colspan="4"></th>
      	</tr>
    	</thead>
    <tbody id="tbd">
    <%
    	for(JobModel jmodel:viewJob)
    	{
    		
    %>
      <tr>
      <td>
        <% 
        	out.print(jmodel.getId());
        	
        %>
        </td>
        <td>
        <% 
        	out.print(jmodel.getJobdescription());
        %>
        </td>
        <td>
        <% 
        	out.print(jmodel.getJobcriteria());
        %>
        </td>
        <td>
        <% 
        	out.print(jmodel.getSalary());
        %>
        </td>
        <td>
        <% 
        	out.print(jmodel.getLocation());
        %>
        </td>
        <td>
       
        	<button id="btn<%=i %>" class="btnAc btn btn-outline-secondary" onclick="update(<%=jmodel.getId()%>)"><%=jmodel.getStatus() %></button>
        	
        </td>
        <td>
        	<button id="Rbtn<%=i %>" class="btnRj btn btn-outline-secondary" onclick="deleteId(<%=jmodel.getId()%>)">Reject</button>
        	<%=i++ %>
        </td>
        </tr>
        <%
			}
		%>
    </tbody>
  </table>
</div>


<%
	}
%>
<script type="text/javascript">
	$(document).ready(function(){
		$(".btnAc").click(function(){
			//console.log(this.id);
			$("#"+this.id).text("accepted");
			$("#R"+this.id).text("Reject");
		});
	});

function update(jobId)
{
	console.log(jobId);
	//document.getElementById("btn").value();
	var resd=document.getElementById("res");
	var respo=new XMLHttpRequest();
	respo.open("GET","UpdateStatus.jsp?jobId="+jobId,true);
	respo.send(null);
	respo.onreadystatechange=function(){
		if(respo.readyState==4 && respo.status==200)
			{
			//document.getElementById("res").innerHTML=respo.responseText;
				
			}
		else
			{
			document.getElementById("res").innerHTML=respo.responseText;
				if(respo.readyState==4 && respo.status==404)
				{
					resd.innerHTML="Page Not Found";
				}
			}
		}
}
function deleteId(jobId)
{
	console.log(jobId);
	//document.getElementById("btn").value();
	var resd=document.getElementById("res");
	var respo=new XMLHttpRequest();
	respo.open("GET","DeleteByid.jsp?jobId="+jobId,true);
	respo.send(null);
	respo.onreadystatechange=function(){
		if(respo.readyState==4 && respo.status==200)
			{
			document.getElementById("res").innerHTML=respo.responseText;
			//$("#tbd").ajax.reload();
			}
		else
			{
			document.getElementById("res").innerHTML=respo.responseText;
				if(respo.readyState==4 && respo.status==404)
				{
					resd.innerHTML="Page Not Found";
				}
			}
		}
}
</script>
<%
}
else
{
	RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
	rd.forward(request,response);
}
%>


</body>
</html>