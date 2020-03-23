package com.jobportal.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddApplicant
 */
@WebServlet("/AddApplicant")
public class AddApplicant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddApplicant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession seekersession1 = null;
		seekersession1 = request.getSession(false);
		PrintWriter out=response.getWriter();
		if (seekersession1.getAttribute("seekerEmail") != null) 
		{
			String value = seekersession1.getAttribute("seekerEmail").toString();
			ConnectionModel cm=new ConnectionModel();
			Model md=cm.checkProfile(value);
			if(md!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Seeker_Profile.jsp");
				request.setAttribute("modelObj", md);
				rd.forward(request, response);
				
			}
			else
			{
				out.println("<script>alert('Applied Succesfully')</script>");
			}
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("SeekerLogin.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
