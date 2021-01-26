package com.Ebug.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Customer_Table {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	@Column
	private String firstName;
	@Column
	private String userName;
	@Column
	private String lastName;
	@Column
	private String emailId;
	@Column
	private long mobileNo;
	private String role;
	@Column
	private String password;
	@Column
	private String confirmPassword;
	private String adharCard;
	
	private String DOB;
	

	public String getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(String adharCard) {
		this.adharCard = adharCard;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Customer_Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Customer_Table(long userId, String firstName, String userName, String lastName, String emailId,
			long mobileNo, String role, String password, String confirmPassword, String adharCard, String dOB) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.userName = userName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.role = role;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.adharCard = adharCard;
		DOB = dOB;
	}









}
