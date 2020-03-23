package com.jobportal.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/JobVerify")
public class JobVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JobVerify() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ConnectionEmployer ce=new ConnectionEmployer();
		
		String jobdescription=request.getParameter("jobdescription");
		String jobcriteria=request.getParameter("jobcriteria");
		String salary=request.getParameter("salary");
		String location=request.getParameter("location");
		
		HttpSession session1=request.getSession(false);
		String employer_id=session1.getAttribute("empid").toString();
		//String employer_id=request.getParameter("employer_id");
		String status=request.getParameter("status");
		//System.out.println(jobdescription+ jobcriteria + salary + location + employer_id + status);
		
		JobModel jmodel=new JobModel(jobdescription, jobcriteria, salary, location, employer_id, status);
		System.out.println(jmodel);
		int insertedjob=ce.addJob(jmodel,employer_id);
		if(insertedjob>0)
		{
			response.getWriter().print("<script>alert('Job Inserted')</script>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("EmployerViewJobs.jsp");;
				dispatcher.forward(request, response);
		}
		else
		{
			response.getWriter().print("<script>alert('Job Not Inserted')</script>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
