<%@page import="com.jobportal.project.Model"%>
<%@page import="java.util.List"%>
<%@page import="com.jobportal.project.AdminConModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin View Seekers</title>
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
	List<Model> viewSeeker=am.registeredSeeker();
	 int i=1;
	if(viewSeeker.size()>0)
	{
%>
<div class ="container">
	<div align="right">
		<form>
			<!-- <input type="submit" value="Refresh List"/>-->
			<button type="button" class="btn btn-outline-info" type="submit">Refresh List</button>
		</form>
	</div><br/>
	<table class="table table-hover">
    	<thead class="thead-dark">
      	<tr>
      		<th>Seeker Id</th>
        	<th>First name</th>
        	<th>Last name</th>
        	<th>Age</th>
        	<th>Email Id</th>
        	<th colspan="4"></th>
      	</tr>
    	</thead>
    <tbody id="tbd">
    <%
    	for(Model model:viewSeeker)
    	{
    		
    %>
      <tr>
      <td>
        <% 
        	out.print(model.getSeekerid());
        	
        %>
        </td>
        <td>
        <% 
        	out.print(model.getFname());
        %>
        </td>
        <td>
        <% 
        	out.print(model.getLname());
        %>
        </td>
        <td>
        <% 
        	out.print(model.getAge());
        %>
        </td>
        <td>
        <% 
        	out.print(model.getEmail());
        %>
        </td>
        <!--  <td>
       
        	<button id="btn<%=i %>" class="btnAc" onclick="update(<%--=jmodel.getId()%>)"><%=jmodel.getStatus() --%></button>
        	
        </td>-->
        <td>
        	<button id="Rbtn<%=i %>" class="btnRm btn btn-outline-secondary" onclick="deleteById(<%=model.getSeekerid()%>)">Remove</button>
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
		$(".btnRm").click(function(){
			//console.log(this.id);
			
			$("#R"+this.id).text("Remove");
		});
	});


function deleteById(SId)
{
	console.log(SId);
	//document.getElementById("btn").value();
	var resd=document.getElementById("res");
	var respo=new XMLHttpRequest();
	respo.open("GET","DeleteSeekerByID.jsp?SId="+SId,true);
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