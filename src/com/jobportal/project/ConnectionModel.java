package com.jobportal.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionModel 
{
	String user="sa";
	String pass="";
	String url="jdbc:h2:tcp://localhost/~/test";
	Model model;
	AdminModel am;
	AdminConModel acm;
	JobModel jmodel;
	EmployerModel em;
	Statement st=null;
	PreparedStatement pst=null;
	
	Connection con=null;
	public boolean getcon()
	{
		try
		{
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection(url,user,pass);
			if(con!=null)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Err "+e);
		}
		return false;
	}
	
	public Connection returnConn() {
		if (getcon()) {
			return con;
		}
		return null;
		
	}
	
	
	public boolean seekerLogin(String email,String password)
	{
		if(getcon())
			{
				String query="select * from Register_Seeker where email='"+email+"' and password='"+password+"'";
				try
				{
				st=con.createStatement();
				ResultSet rst=st.executeQuery(query);
				if(rst.next())
				{
					//Model m=new Model(rst.getInt("Seeker_Id"), rst.getString("Fname"), rst.getString("Lname"), rst.getString("age"), rst.getString("email"), rst.getString("password"), rst.getString("confirmpassword"), null, 0, null, null, null, null, null, null, null	,0.0, 0.0, null, null, 0);
					Model m=new Model(rst.getInt("Seeker_Id"), rst.getString("Fname"), rst.getString("Lname"), rst.getString("age"), rst.getString("email"), rst.getString("password"), rst.getString("confirmpassword"), null, 0, null, null, null, null,null, null, null, 0.0F, 0.0F, null, null, 0);
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
	public boolean RegisterUser(Model model)
	{
		
		int rowinserted=0;
		if(getcon())
		{
			String query="insert into Register_Seeker(Fname,Lname,age,email,password,confirmpassword) values(?,?,?,?,?,?)";
		
			try {
				pst=con.prepareStatement(query);

				pst.setString(1, model.getFname());
				pst.setString(2,model.getLname());
				pst.setString(3,model.getAge());
				pst.setString(4,model.getEmail());
				pst.setString(5, model.getPassword());
				pst.setString(6,model.getConfirmpassword());
				
				rowinserted=pst.executeUpdate();
			} catch (SQLException e) {
			System.out.println("Reg Seeker error: "+e.getMessage());
			
			}
			
			
		}
		if(rowinserted>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	
	public List<JobModel> seekerJobViewAll() 
	{
		List<JobModel>jmodel1 = new ArrayList();

		if (getcon()) 
		{
			String query = "select * from Job_Table where status='accepted' ";
			try 
			{
				st = con.createStatement();
				ResultSet rst = st.executeQuery(query);
				while (rst.next()) 
				{
					jmodel = new JobModel();
					jmodel.setEmployer_id(rst.getString("employer_id"));
					jmodel.setId(rst.getString("job_id"));
					jmodel.setJobdescription(rst.getString("jobdescription"));
					jmodel.setJobcriteria(rst.getString("jobcritics"));
					jmodel.setSalary(rst.getString("package"));
					jmodel.setLocation(rst.getString("location"));
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
	
	/*public List<Model> viewAll()
	{
		List<Model> model1=new ArrayList<Model>();
		if(getcon())
		{
			String query="select * from Register_Seeker";
			try
			{
				st=con.createStatement();
				ResultSet rst=st.executeQuery(query);
				while(rst.next())
				{
					model=new Model();
					model.setFname(rst.getString("fname"));
					model.setLname(rst.getString("lname"));
					model.setAge1(rst.getString("age"));
					model.setEmail(rst.getString("email"));
					model.setPassword(rst.getString("password"));
					model.setConfirmpassword(rst.getString("confirmpassword"));
					model1.add(model);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			System.out.println(model1.size());
			return model1;
		}
		return model1;
	}*/
	

	public JobModel viewJobById(int i) 
	
	{
		
		if (getcon()) {
			String query = "select * from Job_Table where job_id=?";
			//String query="select e.fname,e.comapny_name,j.jobdescription,j.location from Register_Employer e inner join Job_Table j on e.employer_id=j.employer_id";
			try {
			 pst = con.prepareStatement(query);
				pst.setInt(1,i);
				ResultSet rst = pst.executeQuery();
				if(rst.next())
				{
					//em=new EmployerModel();
					//em.setFname(rst.getString("fname"));
					//em.setComapny_name(rst.getString("comapny_name"));
					//em.setContactno(rst.getString("contactno"));
					
					jmodel=new JobModel();
					jmodel.setJobdescription(rst.getString("jobdescription"));
					jmodel.setLocation(rst.getString("location"));
					
					jmodel.setEmployer_id(rst.getString("employer_id"));
				}
			} 
			catch (Exception e) 
			{
				System.out.println("Err: "+e.getMessage());
			}
			
		}
		return jmodel ;
		
		
	}
	
	/*public int updateRecord(Model model)
	{
		int rowCount=0;
		if(getcon())
		{
			System.out.println("Connection Successfull");
			String query="Update Seeker_Profile set fname=?, lname=?, age=?, email=?"
					+ "password=?, confirmpassword=?, qualification=?,hobbies=?"
					+ "address=?, contact=?,tenth_marks=?, twelve_marks=?"
					+ "field=? where id=?";
			try
			{
				pst=con.prepareStatement(query);
				pst.setString(1,model.getFname());
				pst.setString(2,model.getLname());
				pst.setString(3,model.getAge());
				pst.setString(4,model.getEmail());
				pst.setString(5,model.getPassword());
				pst.setString(6,model.getConfirmpassword());
				pst.setString(7,model.getQualification());
				pst.setString(8,model.getHobbies());
				pst.setString(9,model.getAddress());
				pst.setString(10,model.getContact_number());
				pst.setString(11,model.getTenth_marks());
				pst.setString(12,model.getTwelve_marks());
				pst.setString(13,model.getField());
				rowCount=pst.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return rowCount;
	}*/
	
	public boolean insert_profileseeker(Model model)
	{
		int insert=0;
		if(getcon())
		{
			System.out.println("Connection Successfull");
			String query="insert into Seeker_Profile values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try
			{
				pst=con.prepareStatement(query);
				//model.setPsid(rst.psid);
				pst.setString(1,model.getFname());
				pst.setString(2,model.getLname());
				pst.setString(3,model.getEmail());
				pst.setString(4,model.getAddress());
				pst.setString(5,model.getCity());
				pst.setString(6,model.getZip());
				pst.setString(7,model.getQualification());
				pst.setString(8,model.getExtra_certificate());
				pst.setString(9,model.getExpierence());
				pst.setString(10,model.getEarlier_comapny());
				pst.setFloat(11,model.getTenth_marks());
				pst.setFloat(12,model.getTwelve_marks());
				pst.setString(13,model.getHobbies());
				pst.setString(14,model.getBlood_group());
				pst.setInt(15,model.getContact_number());
				insert=pst.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		if(insert>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public Model checkProfile(String value) 
	{
		Model m=null;
		if(getcon())
		{
			String query = "select * from Seeker_Profile where seeker_email=?";
			//String query="select e.fname,e.comapny_name,j.jobdescription,j.location from Register_Employer e inner join Job_Table j on e.employer_id=j.employer_id";
			try {
			 pst = con.prepareStatement(query);
				pst.setString(1,value);
				ResultSet rst1 = pst.executeQuery();
				if(rst1.next())
				{
					
					System.out.println("True");
					return m;
				}
			} 
			catch (Exception e) 
			{
				System.out.println("Err1: "+e.getMessage());
			}
			
		}
		String q = "select * from register_seeker where email=?";
		 try {
			pst = con.prepareStatement(q);
			pst.setString(1,value);
			ResultSet rst = pst.executeQuery();
			if(rst.next())
			{
				m=new Model(rst.getInt("seeker_id"),rst.getString("fname"), rst.getString("lname"), rst.getString("age"), rst.getString("email"), rst.getString("password"), rst.getString("confirmpassword"), null, 0, null, null, null, null, null, null, null, 0.0F, 0.0F, null, null, 0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		System.out.println("False");
		
		return m;
		
	}
	
	
}