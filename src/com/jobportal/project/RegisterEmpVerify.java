package com.jobportal.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegisterEmpVerify")
public class RegisterEmpVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    public RegisterEmpVerify() {
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
		String comapny_name = request.getParameter("comapny_name");
		String contactno = request.getParameter("contactno");
		//String usertype=request.getParameter("usertype");
		EmployerModel empmodel =new EmployerModel();
		
		empmodel.setFname(fname);
		empmodel.setLname(lname);
		empmodel.setAge(age);
		empmodel.setEmail(email);
		empmodel.setPassword(password);
		empmodel.setConfirmpassword(confirmpassword);
		empmodel.setComapny_name(comapny_name);
		empmodel.setContactno(contactno);
		//empmodel.setUsertype(usertype);
		
		ConnectionEmployer ce=new ConnectionEmployer();
		PrintWriter out=response.getWriter();
	
		if(ce.RegisterUser(empmodel))
		{
			//out.println("<style>alert('Registered Successfully')</style>");
			RequestDispatcher rd=request.getRequestDispatcher("EmployerLogin.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("Registration not Successful");
		}
		
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
