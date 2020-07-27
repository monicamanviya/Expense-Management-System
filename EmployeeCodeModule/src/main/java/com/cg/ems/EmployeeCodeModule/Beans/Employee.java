package com.cg.ems.EmployeeCodeModule.Beans;


import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	//@Column(name="EmployeeId")
	private int EmployeeId;
	//@Column(name="EmployeeName")
	private String EmployeeName;
	//@Column(name="EmployeePan")
	private String EmployeePan;
	//@Column(name="EmployeeDesignation")
	private String EmployeeDesignation;
	//@Column(name="EmployeeDomain")
	private String EmployeeDomain;
	//@Column(name="EmployeeDoj")
	private String EmployeeDoj;
	//@Column(name="EmployeeDob")
	private String EmployeeDob;
	//@Column(name="EmployeeSalary")
	private double EmployeeSalary;
	//@Column(name="EmployeeMailId")
	private String EmployeeMailid;
	//@Column(name="EmployeePassword")
	private String EmployeePassword;
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmployeePan() {
		return EmployeePan;
	}
	public void setEmployeePan(String employeePan) {
		EmployeePan = employeePan;
	}
	public String getEmployeeDesignation() {
		return EmployeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		EmployeeDesignation = employeeDesignation;
	}
	public String getEmployeeDomain() {
		return EmployeeDomain;
	}
	public void setEmployeeDomain(String employeeDomain) {
		EmployeeDomain = employeeDomain;
	}
	public String getEmployeeDoj() throws ParseException {
		return reversechangeformat(EmployeeDoj);
	
	}
	public void setEmployeeDoj(String employeeDoj) throws ParseException   {
		
		EmployeeDoj =  changeformat(employeeDoj);
	}
	public String getEmployeeDob() throws ParseException {
		return reversechangeformat(EmployeeDob);
	}
	public void setEmployeeDob(String employeeDob) throws ParseException {
	
		EmployeeDob = changeformat(employeeDob);
	}
	public double getEmployeeSalary() {
		return EmployeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		EmployeeSalary = employeeSalary;
	}
	public String getEmployeeMailid() {
		return EmployeeMailid;
	}
	public void setEmployeeMailid(String employeeMailid) {
		EmployeeMailid = employeeMailid;
	}
	public String getEmployeePassword() {
		return EmployeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		EmployeePassword = employeePassword;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmployeePan=" + EmployeePan
				+ ", EmployeeDesignation=" + EmployeeDesignation + ", EmployeeDomain=" + EmployeeDomain
				+ ", EmployeeDoj=" + EmployeeDoj + ", EmployeeDob=" + EmployeeDob + ", EmployeeSalary=" + EmployeeSalary
				+ ", EmployeeMailid=" + EmployeeMailid + ", EmployeePassword=" + EmployeePassword + "]";
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
