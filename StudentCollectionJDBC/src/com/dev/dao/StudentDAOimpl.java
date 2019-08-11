package com.dev.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dev.beans.Student;
import com.dev.operations.App;

public class StudentDAOimpl implements StudentDAO {

	PreparedStatement pstmt = null;
	Statement stmt = null;
	Student student =new Student();


	@Override
	public Boolean addStudent(Student student) {

		try {
			String query = "insert into student values(?,?,?,?)";
			pstmt = App.mycon.prepareStatement(query);
			pstmt.setInt(1, student.getStud_id());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getEmail());
			pstmt.setString(4, student.getPassword());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student searchStudent(Integer id) {

		try {
			String query = "select * from student where id=?";
			pstmt = App.mycon.prepareStatement(query);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				student.setStud_id(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setPassword(rs.getString(4));
				System.out.println("id is: " + rs.getInt(1));
				System.out.println("name is: " + rs.getString(2));
				System.out.println("email is: " + rs.getString(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public Boolean updateEmail(Integer id, String email) {

		String query = "update student set email =? where id = ?";
		try {
			pstmt = App.mycon.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Boolean deleteStudent(Integer id) {

		String query = "delete from student where id =?";
		try {
			pstmt = App.mycon.prepareStatement(query);
			pstmt.setInt(1, id);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Student showAllStudents() {

		String query = "select * from student";
		try {
			stmt = App.mycon.createStatement();
			ResultSet rs2 = stmt.executeQuery(query);
			while (rs2.next()) {
				System.out.println("student id is: " + rs2.getInt(1));
				System.out.println("student name is: " + rs2.getString(2));
				System.out.println("student email is: " + rs2.getString(3));
				// System.out.println("student password is: "+rs.getString(4));
				System.out.println("------------------------------------------------------------------");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

}
