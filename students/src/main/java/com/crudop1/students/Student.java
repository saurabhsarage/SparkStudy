package com.crudop1.students;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private String student_no;
	private String student_name;
	private String student_dob;
	private String student_doj;
	public String getStudent_no() {
		return student_no;
	}
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_dob() {
		return student_dob;
	}
	public void setStudent_dob(String student_dob) {
		this.student_dob = student_dob;
	}
	public String getStudent_doj() {
		return student_doj;
	}
	public void setStudent_doj(String student_doj) {
		this.student_doj = student_doj;
	}
	@Override
	public String toString() {
		return "Student [student_no=" + student_no + ", student_name=" + student_name + ", student_dob=" + student_dob
				+ ", student_doj=" + student_doj + "]";
	}
	
}
