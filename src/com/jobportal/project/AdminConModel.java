package com.jobportal.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminConModel 
{
	JobModel jmodel;
	AdminModel am;
	Model model;
	Statement st=null;
	PreparedStatement pst=null;
	Connection con;
	ConnectionModel conModel=new ConnectionModel();
	boolean isConnected= conModel.getcon();				
	public boolean checkLogin(String email,String password)
	{
		if(isConnected)
		{
			con=conModel.returnConn();
			String query="select * from Admin_Login where email='"+email+"' and password='"+password+"'";
			try
			{
			st=con.createStatement();
			ResultSet rst=st.executeQuery(query);
			if(rst.next())
			{
				return true;
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		return false;
	}
	public List<JobModel> jobViewAll() 
	{
		List<JobModel>jmodel1 = new ArrayList<JobModel>();

		if (isConnected) 
		{
			con = conModel.returnConn();
			String query = "select * from Job_Table order by status desc";
			try 
			{
				st = con.createStatement();
				ResultSet rst = st.executeQuery(query);
				while (rst.next()) 
				{
					jmodel = new JobModel();
					jmodel.setId(rst.getString("job_id"));
					jmodel.setJobdescription(rst.getString("jobdescription"));
					jmodel.setJobcriteria(rst.getString("jobcritics"));
					jmodel.setSalary(rst.getString("package"));
					jmodel.setLocation(rst.getString("location"));
					jmodel.setEmployer_id(rst.getString("employer_id"));
					jmodel.setStatus(rst.getString("status"));
					jmodel1.add(jmodel);
				}
			}
			 catch (Exception e) 
			 {
				System.out.println(e.getMessage());
			 }
			
			
		}
		return jmodel1;
	}
	//Admin viewing seeker
	public List<Model> registeredSeeker() 
	{
		List<Model>model1 = new ArrayList<Model>();

		if (isConnected) 
		{
			con = conModel.returnConn();
			String query = "select seeker_id, fname, lname, age, email from Register_Seeker ";
			try 
			{
				st = con.createStatement();
				ResultSet rst = st.executeQuery(query);
				while (rst.next()) 
				{
					model = new Model();
					model.setSeekerid(rst.getInt("seeker_id"));
					model.setFname(rst.getString("fname"));
					model.setLname(rst.getString("lname"));
					model.setAge(rst.getString("age"));
					model.setEmail(rst.getString("email"));
					
					
					/*jmodel.setId(rst.getString("job_id"));
					jmodel.setJobdescription(rst.getString("jobdescription"));
					jmodel.setJobcriteria(rst.getString("jobcriteria"));
					jmodel.setSalary(rst.getString("salary"));
					jmodel.setLocation(rst.getString("location"));
					jmodel.setEmployer_id(rst.getString("employer_id"));
					jmodel.setStatus(rst.getString("status"));*/
					model1.add(model);
				}
			}
			 catch (Exception e) 
			 {
				System.out.println(e.getMessage());
			 }
			
			
		}
		return model1;
	}
	
	public int updateRecord(String jobId)
	{
		
		
		if(isConnected)
		
		{
			con=conModel.returnConn();
			String query="update Job_Table set status='accepted' where job_id=?";
			
			try
			{
				
				st=con.createStatement();
				pst=con.prepareStatement(query);
				pst.setString(1, jobId);
				pst.executeUpdate();
				return 1;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				return 2;
			}
			
			
		}
		else
		{
			System.out.println("Connection Is Not Possible");
			return 3;
		}
		
		
	}
	
	//delete jobs from admin page
	public int deleteRecords(String jobId)
	{
		int deleterows=0;
		if(isConnected)
		{
			con=conModel.returnConn();
			String query="delete Job_Table where job_id=?";
			try
			{
				pst=con.prepareStatement(query);
				pst.setString(1,jobId);
				deleterows=pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		
		return deleterows;
	}
	
	//delete seekers from admin page
		public int deleteSeekerRecords(int seekerid)
		{
			int deleterows=0;
			if(isConnected)
			{
				con=conModel.returnConn();
				String query="delete Register_Seeker where seeker_id=?";
				try
				{
					pst=con.prepareStatement(query);
					pst.setInt(1,seekerid);
					deleterows=pst.executeUpdate();
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
				
			}
			
			return deleterows;
		}
	
	//give the count of the pending jobs
	public int getPendingCounts() 
	{
		int pendingJobCount=0;
		if (isConnected) 
		{
			con = conModel.returnConn();
			String query = "select count(*) pCount from Job_Table where status='pending'";
			try 
			{
				st = con.createStatement();
				ResultSet rst = st.executeQuery(query);
				if (rst.next()) 
				{
					 pendingJobCount=rst.getInt("pCount");
				}
			}
			 catch (Exception e) 
			 {
				System.out.println(e.getMessage());
			 }
			
			
		}
		return pendingJobCount;
	}

}
