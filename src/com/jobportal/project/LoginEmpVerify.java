package com.jobportal.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/LoginEmpVerify")
public class LoginEmpVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginEmpVerify() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//String usertype=request.getParameter("usertype");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		ConnectionEmployer ce=new ConnectionEmployer();
		boolean success=ce.employerLogin(email, password);
		String eid;
		eid=ce.eid;
		System.out.println(eid);
		HttpSession session=request.getSession();
		session.setAttribute("empid",eid);
		session.setAttribute("userType","employer");
		
		if(success)
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("EmployerViewJobs.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("EmployerLogin.jsp");
			rd.forward(request,response);
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
