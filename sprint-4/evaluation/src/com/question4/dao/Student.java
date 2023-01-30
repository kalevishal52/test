package com.question4.dao;

public class Student {

	private int roll;
	private String name;
	private String standard;
	private String date;
	private int fees;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int roll, String name, String standard, String date, int fees) {
		super();
		this.roll = roll;
		this.name = name;
		this.standard = standard;
		this.date = date;
		this.fees = fees;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", standard=" + standard + ", date=" + date + ", fees="
				+ fees + "]";
	}
	
	
	
}
