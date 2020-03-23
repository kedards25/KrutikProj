package com.jobportal.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterSeekerVerify")
public class RegisterSeekerVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterSeekerVerify() 
    {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String age=request.getParameter("age");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		
		Model model =new Model();
		
		model.setFname(fname);
		model.setLname(lname);
		model.setAge(age);
		model.setEmail(email);
		model.setPassword(password);
		model.setConfirmpassword(confirmpassword);
		
		ConnectionModel cm=new ConnectionModel();
		if(cm.RegisterUser(model))
		{
			RequestDispatcher rd=request.getRequestDispatcher("SeekerLogin.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Connection not Successfully 123");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
