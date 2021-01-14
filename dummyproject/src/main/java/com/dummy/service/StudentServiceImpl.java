package com.dummy.service;

import java.util.List;

import com.dummy.DAO.StudentDAOImpl;
import com.dummy.beans.Student;

public class StudentServiceImpl implements StudentService {

	StudentDAOImpl s = new StudentDAOImpl();
	@Override
	public List<Student> getAllStudents() {
		return s.getAllStudents();
	}

	@Override
	public void addStudent(Student stu) {
		s.addStudent(stu);
	}

	@Override
	public boolean updateStudent(Student stu) {
		s.updateStudentName(stu);
		return false;
	}

}
