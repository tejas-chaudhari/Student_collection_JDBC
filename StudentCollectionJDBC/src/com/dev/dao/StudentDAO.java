package com.dev.dao;

import com.dev.beans.Student;

public interface StudentDAO {

	Boolean addStudent(Student student);
	Student searchStudent(Integer id);
	Boolean updateEmail(Integer id,String email);
	Boolean deleteStudent(Integer id);
	Student showAllStudents();
	
}
