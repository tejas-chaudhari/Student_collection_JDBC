package com.dev.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.dev.beans.Student;
import com.dev.exceptions.StudentNotAddedException;
import com.dev.exceptions.StudentNotFoundException;
import com.dev.services.StudentServices;
import com.dev.services.StudentServicesimpl;

public class App {

	static Scanner sc = new Scanner(System.in);
	public static Connection mycon;
	static StudentNotFoundException snfe = new StudentNotFoundException();

	public static void main(String[] args) {
		StudentServices serv = new StudentServicesimpl();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/caps_buggers";
			System.out.println("enter user:");
			String user = sc.nextLine();
			System.out.println("enter password");
			String password = sc.nextLine();
			mycon = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Estd...");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Student student = new Student();

		app: while (true) {

			System.out.println("press 1 to add student");
			System.out.println("press 2 to search student");
			System.out.println("press 3 to update email");
			System.out.println("press 4 to delete student");
			System.out.println("press 5 to show all students");
			System.out.println("press 6 to exit");

			Integer choice = Integer.parseInt(sc.nextLine());

			switch (choice) {

			case 1:

				System.out.println("enter id");
				student.setStud_id(Integer.parseInt(sc.nextLine()));
				System.out.println("enter name");
				student.setName(sc.nextLine());
				System.out.println("enter email");
				student.setEmail(sc.nextLine());
				System.out.println("enter password");
				student.setPassword(sc.nextLine());

				Boolean add = serv.addStudentService(student);
				if (add) {
					System.out.println("data inserted" + "\n");
				} else {
					throw new StudentNotAddedException();
				}
				break;

			case 2:

				System.out.println("enter id to search");
				student = serv.searchStudentService(Integer.parseInt(sc.nextLine()));
				if (student.getStud_id() != null) {
					System.out.println("above are search results" + "\n");
				} else {
					throw new StudentNotFoundException();
				}
				break;

			case 3:
				System.out.println("enter id to update email");
				Integer id = Integer.parseInt(sc.nextLine());
				System.out.println("enter new email id");
				String email = sc.nextLine();

				Boolean update = serv.updateEmailService(id, email);
				if (update) {
					System.out.println("email updated"+ "\n");
				} else {
					System.out.println("error");
				}
				break;

			case 4:
				System.out.println("enter id to delete student");
				Boolean delete = serv.deleteStudentService(Integer.parseInt(sc.nextLine()));
				if (delete) {
					System.out.println("record deleted"+ "\n");
				} else {
					System.out.println("error");
					throw snfe;
				}
				break;

			case 5:
				serv.showAllStudentsService();

			case 6:
				try {
					mycon.close();
					sc.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thank you!!");
				break app;
				
			}

		}

	}

}
