package com.cg.ems.ExpenseClaimedModule.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="expenseclaimed")
public class ExpenseClaimed {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int expenseCode;
	private int empId;
	private int projectCode;
	private int expenseId;
	private String startDate;
	private String endDate;
	private int expenseAmt;
	
	
	public ExpenseClaimed() {
		super();
	
	}


	public ExpenseClaimed(Integer expenseCode, int empId, int projectCode, int expenseId, String startDate, String endDate,
			int expenseAmt) {
		super();
		this.expenseCode = expenseCode;
		this.empId = empId;
		this.projectCode = projectCode;
		this.expenseId = expenseId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.expenseAmt = expenseAmt;
	}


	public Integer getExpenseCode() {
		return expenseCode;
	}


	public void setExpenseCode(Integer expenseCode) {
		this.expenseCode = expenseCode;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public int getProjectCode() {
		return projectCode;
	}


	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}


	public int getExpenseId() {
		return expenseId;
	}


	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}


	public String getStartDate()throws ParseException {
		return reversechangeformat(startDate);
	}


	public void setStartDate(String startDate)throws ParseException {
		this.startDate = changeformat(startDate);
	}


	public String getEndDate() throws ParseException {
		return reversechangeformat(endDate);
	}


	public void setEndDate(String endDate)throws ParseException {
		this.endDate = changeformat(endDate);
	}


	public int getExpenseAmt() {
		return expenseAmt;
	}


	public void setExpenseAmt(int expenseAmt) {
		this.expenseAmt = expenseAmt;
	}


	@Override
	public String toString() {
		return "ExpenseClaimed [expenseCode=" + expenseCode + ", empId=" + empId + ", projectCode=" + projectCode
				+ ", expenseId=" + expenseId + ", startDate=" + startDate + ", endDate=" + endDate + ", expenseAmt="
				+ expenseAmt + "]";
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
