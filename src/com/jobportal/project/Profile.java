package com.jobportal.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Profile() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String address=request.getParameter("inputAddress");
		String city=request.getParameter("inputCity");
		String zip=request.getParameter("inputZip");
		String qualification=request.getParameter("qualification");
		String extra_certificate=request.getParameter("certificate");
		String experience=request.getParameter("experience");
		String cmpname=request.getParameter("cmpname");
		float tenmarks=Float.parseFloat(request.getParameter("tenmarks"));
		float tmarks=Float.parseFloat(request.getParameter("tmarks"));
		String hobbies=request.getParameter("hobbies");
		String bgroup=request.getParameter("bgroup");
		int cnumber=Integer.parseInt(request.getParameter("cnumber"));
		
		Model model=new Model();
		
		model.setFname(fname);
		model.setLname(lname);
		model.setEmail(email);
		model.setAddress(address);
		model.setCity(city);
		model.setZip(zip);
		model.setQualification(qualification);
		model.setExtra_certificate(extra_certificate);
		model.setExpierence(experience);
		model.setEarlier_comapny(cmpname);
		model.setTenth_marks(tenmarks);
		model.setTwelve_marks(tmarks);
		model.setHobbies(hobbies);
		model.setBlood_group(bgroup);
		model.setContact_number(cnumber);
		
		ConnectionModel cm=new ConnectionModel();
		PrintWriter out=response.getWriter();
		
		if(cm.insert_profileseeker(model))
		{
			//out.println("Successfull");
			RequestDispatcher rd=request.getRequestDispatcher("Faltu.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("Not Successful");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
