package com.jobportal.project;

public class JobModel 
{
	String id;
	String jobdescription;
	String jobcriteria;
	String salary;
	String location;
	String employer_id;
	String status;
	
	
	public JobModel(String jobdescription, String jobcriteria, String salary, String location, String employer_id, String status) 
	{
		this.jobdescription=jobdescription;
		this.jobcriteria=jobcriteria;
		this.salary=salary;
		this.location=location;
		this.employer_id=employer_id;
	}
	
	public JobModel()
	{
		super();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public String getJobcriteria() {
		return jobcriteria;
	}
	public void setJobcriteria(String jobcriteria) {
		this.jobcriteria = jobcriteria;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getEmployer_id() {
		return employer_id;
	}

	public void setEmployer_id(String employer_id) {
		this.employer_id = employer_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "JobModel [id=" + id + ", jobdescription=" + jobdescription + ", jobcriteria=" + jobcriteria
				+ ", salary=" + salary + ", location=" + location + ", employer_id=" + employer_id +" status=" + status + "]";
	}
	
}
