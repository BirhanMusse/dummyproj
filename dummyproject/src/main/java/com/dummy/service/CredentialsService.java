package com.dummy.service;

import java.util.List;

import com.dummy.beans.Credentials;
import com.dummy.beans.Student;

public interface CredentialsService {

	public void createCreds(Credentials creds);
	public void updateCreds(Credentials creds);
	public Student getUserbyUnameAndPword(String user, String pass);
	public List<Credentials> viewAllCreds();
}
