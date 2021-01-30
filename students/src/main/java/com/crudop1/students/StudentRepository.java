package com.crudop1.students;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class StudentRepository {

	Connection con = null;

	public StudentRepository() {
		String url = "jdbc:mysql://127.0.0.1:3306/crudopdb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "saurabh123");

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		String sql = "select * from student";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student a = new Student();
				a.setStudent_no(rs.getString(1));
				a.setStudent_name(rs.getString(2));
				a.setStudent_dob(rs.getDate(3).toString());
				a.setStudent_doj(rs.getDate(4).toString());
				students.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	public Student getStudent(String id) {
		Student a = new Student();
		String sql = "select * from student where student_no = '" + id + "'";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {

				a.setStudent_no(rs.getString(1));
				a.setStudent_name(rs.getString(2));
				a.setStudent_dob(rs.getString(3));
				a.setStudent_doj(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public String create(Student a) {
		String sql = "insert into student values(?,?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, a.getStudent_no());
			stmt.setString(2, a.getStudent_name());
			stmt.setString(3, a.getStudent_dob());
			stmt.setString(4, a.getStudent_doj());
			stmt.executeUpdate();
			return "Successfully Inserted";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Not Inserted";
	}

	public String update(Student a) {
		String sql = "update student set student_name=?, student_dob=?, student_doj=? where student_no=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(4, a.getStudent_no());
			stmt.setString(1, a.getStudent_name());
			stmt.setString(2, a.getStudent_dob());
			stmt.setString(3, a.getStudent_doj());
			stmt.executeUpdate();
			return "Successfully Updated";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Not Found";
	}

	public String delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from student where student_no = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();
			return "Successfully Deleted";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Not Found";
	}
}
