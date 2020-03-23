<%@page import="com.jobportal.project.AdminConModel"%>
<%@page import="java.io.Console"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.jobportal.project.ConnectionModel"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.jobportal.project.AdminModel"%>
<%@page import="com.jobportal.project.JobModel"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String jId=request.getParameter("jobId");
AdminConModel am=new AdminConModel();
int res=am.updateRecord(jId);

if(res==1)
{
	out.println("<script> console.log('Update is done !!');</script>");
}
else
{
	out.println("<script> console.log('Update not done !!');</script>");
}

%>
</body>
</html>