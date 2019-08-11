package com.dev.services;

import com.dev.beans.Student;

public interface StudentServices {

	Boolean addStudentService(Student student);
	Student searchStudentService(Integer id);
	Boolean updateEmailService(Integer id,String email);
	Boolean deleteStudentService(Integer id);
	Student showAllStudentsService();
}
