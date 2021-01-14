package com.dummy.service;

import java.util.List;

import com.dummy.beans.Student;

public interface StudentService {
	List<Student> getAllStudents();
	public void addStudent(Student s);
	public boolean updateStudent(Student s);
}
