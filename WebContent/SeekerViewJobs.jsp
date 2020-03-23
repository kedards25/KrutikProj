<%@page import="com.jobportal.project.ConnectionEmployer"%>
<%@page import="com.jobportal.project.EmployerModel"%>
<%@page import="java.util.List"%>
<%@page import="com.jobportal.project.JobModel"%>
<%@page import="com.jobportal.project.ConnectionModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seeker View Jobs</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="res"></div>

	<%
		//HttpSession seekersession1 = null;
		//seekersession1 = request.getSession(false);
		//if (seekersession1.getAttribute("seekerEmail") != null) {
			//String value = seekersession1.getAttribute("seekerEmail").toString();
			ConnectionModel cm = new ConnectionModel();
			ConnectionEmployer ce = new ConnectionEmployer();

			// boolean emp=ce.RegisterUser(em);
			List<JobModel> viewJobs = cm.seekerJobViewAll();
			int i = 1;
			if (viewJobs.size() > 0) {
	%>
		<!--<jsp:include page="NavBar.jsp"></jsp:include>-->
	<div class="container">

		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<!--<th>Job Description</th>-->
					<th>Employer Name</th>
					<th>Company Name</th>
					<th>Job Criteria</th>
					<th>Salary</th>
					<!--<th>Location</th>-->
					<th colspan="4"></th>
				</tr>
			</thead>
			<tbody id="tbd">
				<%
					for (JobModel jmodel : viewJobs) {
								EmployerModel em = ce.viewEmployerById(jmodel.getEmployer_id());
				%>
				<tr class="shadow p-3 mb-5 bg-white rounded">
					<!--<td>
       <%-- <% 
        	out.print(jmodel.getJobdescription());
        %>--%>
        </td>-->
					<td>
						<%
							out.print(em.getFname());
						%>
					</td>
					<td>
						<%
							out.print(em.getComapny_name());
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

					<td><a
						href="ApplyJob.jsp?jobId=<%out.print(jmodel.getId());%>"><button class="btn btn-outline-secondary">Apply</button></a>
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
			else
			{
				out.print("No data found");
			}
		
	%>
	<script type="text/javascript">
		//setTimeout(function() {
			//location = 'http://localhost:8080/Job_Portal/SeekerViewJobs.jsp'
		//}, 10000)
	</script>
</body>
</html>