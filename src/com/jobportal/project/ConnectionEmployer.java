package com.jobportal.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class ConnectionEmployer {
	EmployerModel empmodel;
	JobModel jmodel;
	Statement st = null;
	PreparedStatement pst;
	String eid;
	String usertype;
	Connection con = null;
	ConnectionModel conModel = new ConnectionModel();
	boolean isConnected = conModel.getcon();

	public boolean RegisterUser(EmployerModel empmodel) {
		int rowinserted = 0;
		if (isConnected) {
			con = conModel.returnConn();

			String query = "insert into Register_Employer values(?,?,?,?,?,?,?,?)";
			try {

				pst = con.prepareStatement(query);
				pst.setString(1, empmodel.getFname());
				pst.setString(2, empmodel.getLname());
				pst.setString(3, empmodel.getAge());
				pst.setString(4, empmodel.getEmail());
				pst.setString(5, empmodel.getPassword());
				pst.setString(6, empmodel.getConfirmpassword());
				pst.setString(7, empmodel.getComapny_name());
				pst.setString(8, empmodel.getContactno());
				// pst.setString(9, empmodel.getUsertype());
				rowinserted = pst.executeUpdate();
				System.out.println(rowinserted);
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}

		if (rowinserted > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean employerLogin(String email, String password) {

		if (isConnected) {
			boolean flag = false;
			con = conModel.returnConn();
			String query = "select * from Register_Employer where email='" + email + "' and password='" + password
					+ "'";
			try {
				st = con.createStatement();
				ResultSet rst = st.executeQuery(query);
				while (rst.next()) {
					// usertype=rst.getString("usertype");
					eid = rst.getString("employer_id");
					flag = true;
				}
				return flag;

			} catch (Exception e) {
				System.out.println(e);
			}

		}
		return false;
	}

	public int addJob(JobModel jmodel, String eid) {
		String jobdescription = jmodel.getJobdescription();
		String jobcriteria = jmodel.getJobcriteria();
		String salary = jmodel.getSalary();
		String location = jmodel.getLocation();
		// String employer_id=jmodel.getEmployer_id();
		// System.out.println(jobdescription+ jobcriteria + salary + location +
		// employer_id +);
		int add = 0;
		if (isConnected) {

			con = conModel.returnConn();

			String query = "insert into Job_Table(jobdescription,jobcritics,package,location,employer_id,status) values(?,?,?,?,?,'pending')";
			try {
				pst = con.prepareStatement(query);
				pst.setString(1, jobdescription);
				pst.setString(2, jobcriteria);
				pst.setString(3, salary);
				pst.setString(4, location);
				pst.setString(5, eid);
				add = pst.executeUpdate();

				System.out.println();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return add;
	}

	public EmployerModel viewEmployerById(String i)

	{
		if (isConnected) {
			con = conModel.returnConn();
			String query = "select * from Register_Employer where employer_id=?";
			try {
				PreparedStatement preparestmt = con.prepareStatement(query);
				System.out.println(i);
				preparestmt.setString(1, i);
				ResultSet rst = preparestmt.executeQuery();
				if (rst.next()) {
					empmodel = new EmployerModel();
					empmodel.setFname(rst.getString("fname"));
					empmodel.setLname(rst.getString("lname"));
					empmodel.setAge(rst.getString("age"));
					empmodel.setEmail(rst.getString("email"));
					empmodel.setPassword(rst.getString("password"));
					empmodel.setConfirmpassword(rst.getString("confirmpassword"));
					empmodel.setComapny_name(rst.getString("comapny_name"));
					empmodel.setContactno(rst.getString("contactno"));
//					empmodel.setEmployer_number(rst.getInt("employer_number"));
//					empmodel.setJob_requirement(rst.getString("job_requirement"));

				}
			} catch (Exception e) {
				System.out.println("by Id:" + e.getMessage());
			}

		}
		return empmodel;

	}

	public List<JobModel> jobViewAll() {
		List<JobModel> jmodel1 = new ArrayList<JobModel>();

		if (isConnected) {
			con = conModel.returnConn();
			String query = "select * from Job_Table where employer_id=?";
			try {
				st = con.createStatement();

				ResultSet rst = st.executeQuery(query);
				while (rst.next()) {
					jmodel = new JobModel();
					jmodel.setId(rst.getString("job_id"));
					jmodel.setJobdescription(rst.getString("jobdescription"));
					jmodel.setJobcriteria(rst.getString("jobcriteria"));
					jmodel.setSalary(rst.getString("salary"));
					jmodel.setLocation(rst.getString("location"));
					// jmodel.setEmployer_id(rst.getString("employer_id"));
					jmodel.setStatus(rst.getString("status"));
					jmodel1.add(jmodel);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		return jmodel1;
	}

	/*
	 * public boolean insert_profileemployer(EmployerModel model) { int insert = 0;
	 * if (isConnected) { con = conModel.returnConn(); String query =
	 * "Insert into Register_Employer values(?,?,?,?,?,?,?,?)"; try { pst =
	 * con.prepareStatement(query); pst.setString(1, empmodel.getFname());
	 * pst.setString(2, empmodel.getLname()); pst.setString(4, empmodel.getEmail());
	 * pst.setString(3, empmodel.getAge()); pst.setString(5,
	 * empmodel.getPassword()); pst.setString(6, empmodel.getConfirmpassword()); //
	 * pst.setInt(7,empmodel.getEmployer_number()); //
	 * pst.setString(8,empmodel.getJob_requirement()); insert = pst.executeUpdate();
	 * } catch (Exception e) { System.out.println(e); } } if (insert > 0) { return
	 * true; } else { return false; } }
	 * 
	 * public int updateRecord(EmployerModel emodel) { int rowEmpCount = 0; if
	 * (isConnected) { con = conModel.returnConn(); String query =
	 * "Update Employer_Profile set fname=?, lname=?, age=?, email=?" +
	 * "password=?, confirmpassword=?, company_no=?,company_name=?" +
	 * "employer_no=?, job_requirement=?"; try { pst = con.prepareStatement(query);
	 * pst.setString(1, emodel.getFname()); pst.setString(2, emodel.getLname());
	 * pst.setString(3, emodel.getAge()); pst.setString(4, emodel.getEmail());
	 * pst.setString(5, emodel.getPassword()); pst.setString(6,
	 * emodel.getConfirmpassword()); pst.setString(7, emodel.getComapny_name());
	 * pst.setString(8, emodel.getContactno()); //
	 * pst.setInt(9,emodel.getEmployer_number()); //
	 * pst.setString(10,emodel.getJob_requirement()); rowEmpCount =
	 * pst.executeUpdate(); } catch (Exception e) { System.out.println(e); } }
	 * return rowEmpCount; }
	 */

	public List<JobModel> viewJobByEmp(int empId) {
		List<JobModel> jmodel1 = new ArrayList<JobModel>();

		if (isConnected) {
			con = conModel.returnConn();
			String query = "select * from Job_Table where employer_id=" + empId;
			try {
				st = con.createStatement();
				ResultSet rst = st.executeQuery(query);
				while (rst.next()) {
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		return jmodel1;

	}

}
