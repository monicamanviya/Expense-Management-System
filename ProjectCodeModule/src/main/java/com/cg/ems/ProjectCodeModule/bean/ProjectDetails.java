package com.cg.ems.ProjectCodeModule.bean;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_details")
public class ProjectDetails {

	@Id
	@Column(name = "project_code")
	private int projectCode;
	@Column(name = "project_desc")
	private String projectDesc;
	@Column(name = "start_date")
	private String startDate;
	@Column(name = "end_date")
	private String endDate;
	@Column(name = "business_unit")
	private String businessUnti;

	public ProjectDetails() {
		super();
	}

	public ProjectDetails(int projectCode, String projectDesc, String startDate, String endDate,
			String businessUnti) {
		super();
		this.projectCode = projectCode;
		this.projectDesc = projectDesc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.businessUnti = businessUnti;
	}

	public int getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getStartDate() throws ParseException{
		return reversechangeformat(startDate);
	}

	public void setStartDate(String startDate) throws ParseException  {
		this.startDate = changeformat(startDate);
	}

	public String getEndDate()throws ParseException {
		return reversechangeformat(endDate);
	}

	public void setEndDate(String endDate)throws ParseException {
		this.endDate =  changeformat(endDate);
	}

	public String getBusinessUnti() {
		return businessUnti;
	}

	public void setBusinessUnti(String businessUnti) {
		this.businessUnti = businessUnti;
	}

	@Override
	public String toString() {
		return "ProjectDetails [projectCode=" + projectCode + ", projectDesc=" + projectDesc + ", startDate="
				+ startDate + ", endDate=" + endDate + ", businessUnti=" + businessUnti + "]";
	}
	
	public String changeformat(String oldDate) throws ParseException
	{
		String datereceived = oldDate;
		DateFormat userDateFormat = new SimpleDateFormat("dd/mm/yyyy");
		DateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-mm-dd");
		Date date = userDateFormat.parse(oldDate);
		String convertedDaTE = dateFormatNeeded.format(date);
		return  convertedDaTE ;
		
	}
	
	public String reversechangeformat(String oldDate) throws ParseException
	{
		String datereceived = oldDate;
		DateFormat userDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		DateFormat dateFormatNeeded = new SimpleDateFormat("dd/mm/yyyy");
		Date date = userDateFormat.parse(oldDate);
		String convertedDaTE = dateFormatNeeded.format(date);
		return  convertedDaTE ;
		
	}

}
