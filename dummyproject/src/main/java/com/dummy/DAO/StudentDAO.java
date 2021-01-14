package com.dummy.DAO;

import java.util.List;

import com.dummy.beans.Student;

public interface StudentDAO {

	List<Student> getAllStudents();
	public void addStudent(Student s);
	public boolean updateStudentName(Student s);

}
