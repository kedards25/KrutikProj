<%@page import="com.jobportal.project.AdminConModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="NavBar.jsp"></jsp:include>
<%
String jobId=request.getParameter("jobId");
AdminConModel ac=new AdminConModel();
int delete=ac.deleteRecords(jobId);
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