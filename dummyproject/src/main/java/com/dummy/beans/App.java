package com.dummy.beans;

import com.dummy.DAO.StudentDAOImpl;
import com.dummy.service.CredentialsServiceImpl;

public class App {
   

    	public static void main(String[] args) {
    		StudentDAOImpl l = new StudentDAOImpl();
    		Student s = new Student("Hannah", "Montanama", "Birhanlmusse@gmail.com");
    		l.addStudent(s);
    		
    		CredentialsServiceImpl cs = new CredentialsServiceImpl();
    		cs.createCreds(new Credentials("USERNAME!!", "PASSWORKED!!"));
    		
    	}
}