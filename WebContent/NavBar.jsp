<%@page import="com.jobportal.project.AdminConModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NavBar</title>
</head>
<body>
	<%
	int pendingJobs=0;
		String link1Txt = "", link2Txt = "", link3Txt = "", link4Txt = "",link1 = "", link2 = "", link3 = "", link4 = "";
	%>
	<nav
		class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-between">
		
		<%
			HttpSession sess = request.getSession(false);
			String userType = sess.getAttribute("userType").toString();
			if (userType.equals("adminSession")) {
				AdminConModel acm = new AdminConModel();
				link1Txt="Admin";link1="ViewJob.jsp";
				link2Txt="Jobs"; link2="ViewJob.jsp";
				link3Txt="Seekers";link3="ViewRegisteredSeekers.jsp";
				link4Txt="Employers";link4="#";
				 pendingJobs= acm.getPendingCounts();
				
				
		%>

		


		<%
			
			} else if (userType.equals("employer")) {
				link1Txt="Employer";link1="EmployerViewJobs.jsp";
				link2Txt="Add Jobs"; link2="AddJob.jsp";
				link3Txt="My Jobs";link3="EmployerViewJobs.jsp";
				link4Txt="Applicants";link4="ViewApplicantsByEmpId.jsp";

			} else{
				link1Txt="Applicant";link1="Profile.jsp";
				link2Txt="Jobs"; link2="SeekerViewJobs.jsp";
				link3Txt="Notifications";link3="NotificySeeker.jsp";
			}
		%>
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="<%=link1%>"><%=link1Txt%></a>
			</li>
			<li class="nav-item active"><a class="nav-link" href="<%=link2%>"><%=link2Txt%></a>
			</li>
			<li class="nav-item active"><a class="nav-link" href="<%=link3%>"><%=link3Txt%></a>
			</li>
			<li class="nav-item active"><a class="nav-link" href="<%=link4%>"><%=link4Txt%></a>
			</li>
		</ul>
		<%
		if (pendingJobs > 0) {
		%>
		<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">
			Pending <span class="badge badge-light"><%=pendingJobs%></span>
		</button>
		<%
		}
		%>
	</nav>
	<br />
	<br />
</body>
</html>