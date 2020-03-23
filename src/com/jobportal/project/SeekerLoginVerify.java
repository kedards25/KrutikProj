package com.jobportal.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SeekerLoginVerify")
public class SeekerLoginVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SeekerLoginVerify() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("seekerEmail");
		String password=request.getParameter("password");
		ConnectionModel cm=new ConnectionModel();
		boolean success=cm.seekerLogin(email, password);
		
		if(success)
		{
			HttpSession seekersession=request.getSession();
			seekersession.setAttribute("seekerEmail", email);
			seekersession.setAttribute("userType", "seekerSession");
			RequestDispatcher rd=request.getRequestDispatcher("SeekerViewJobs.jsp");
			rd.forward(request,response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("SeekerLogin.jsp");
			rd.forward(request,response);
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
