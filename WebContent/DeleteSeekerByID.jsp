<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.jobportal.project.AdminConModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Seeker</title>
</head>
<body>


<%
int seekerid=Integer.parseInt(request.getParameter("SId"));
AdminConModel ac=new AdminConModel();
int delete=ac.deleteSeekerRecords(seekerid);
if(delete>0)
{
%>
<script>
	alert("Successfully Removed !!!!");
</script>
<%}
%>

</body>
</html>
</body>
</html>