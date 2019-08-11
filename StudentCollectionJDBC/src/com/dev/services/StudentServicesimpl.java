package com.dev.services;

import com.dev.beans.Student;
import com.dev.dao.StudentDAO;
import com.dev.dao.StudentDAOimpl;

public class StudentServicesimpl implements StudentServices {
	
	StudentDAO sdao = new StudentDAOimpl();

	@Override
	public Boolean addStudentService(Student student) {
		// TODO Auto-generated method stub
		return sdao.addStudent(student);
	}

	@Override
	public Student searchStudentService(Integer id) {
		// TODO Auto-generated method stub
		return sdao.searchStudent(id);
	}

	@Override
	public Boolean updateEmailService(Integer id, String email) {
		// TODO Auto-generated method stub
		return sdao.updateEmail(id, email);
	}

	@Override
	public Boolean deleteStudentService(Integer id) {
		// TODO Auto-generated method stub
		return sdao.deleteStudent(id);
	}

	@Override
	public Student showAllStudentsService() {
		// TODO Auto-generated method stub
		return sdao.showAllStudents();
	}

	
}
