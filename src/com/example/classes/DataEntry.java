package com.example.classes;

public class DataEntry 
{

	String date,amount,phoneNumber,approvalNumber;
	public DataEntry (String date, String amount, String phoneNumber, String approvalNumber)
	{
		this.date=date;
		this.amount=amount;
		this.phoneNumber=phoneNumber;
		this.approvalNumber=approvalNumber;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getApprovalNumber() {
		return approvalNumber;
	}
	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}
}