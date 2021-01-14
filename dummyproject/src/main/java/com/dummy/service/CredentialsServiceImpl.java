package com.dummy.service;

import java.util.List;

import com.dummy.DAO.CredentialsDAOImpl;
import com.dummy.beans.Credentials;
import com.dummy.beans.Student;

public class CredentialsServiceImpl implements CredentialsService{
	CredentialsDAOImpl cd = new CredentialsDAOImpl();
	@Override
	public void createCreds(Credentials creds) {
		cd.createCreds(creds);		
	}

	@Override
	public void updateCreds(Credentials creds) {
		cd.updateCreds(creds);		
	}

	@Override
	public Student getUserbyUnameAndPword(String user, String pass) {
	return cd.getUserbyUnameAndPword(user, pass);
	}

	@Override
	public List<Credentials> viewAllCreds() {
		return cd.viewAllCreds();
	}

}
