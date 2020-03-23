package com.jobportal.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/AdminVerifyServlet")
public class AdminVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminVerifyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//String usertype=request.getParameter("usertype");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		AdminConModel am=new AdminConModel();
		boolean success=am.checkLogin(email, password);
		if(success)
		{
			HttpSession adminsession=request.getSession();
			adminsession.setAttribute("AdminUser",email);
			adminsession.setAttribute("userType", "adminSession");
			RequestDispatcher rd=request.getRequestDispatcher("ViewJob.jsp");
			rd.forward(request,response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request,response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
