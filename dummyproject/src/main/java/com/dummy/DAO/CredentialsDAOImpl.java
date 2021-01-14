package com.dummy.DAO;

import java.util.List;

import javax.persistence.Query;

import org.h2.engine.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dummy.beans.Credentials;
import com.dummy.beans.Student;
import com.dummy.util.HibernateUtil;

public class CredentialsDAOImpl implements CredentialsDAO{

	private SessionFactory factory = HibernateUtil.getSessionFactory();
	
	

	@Override
	public List<Credentials> viewAllCreds() {
		List<Credentials> creds;
		Session s = factory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		creds=s.createQuery("from Credentials", Credentials.class).getResultList();
		tx.commit();
		return creds;

	}

	@Override
	public void updateCreds(Credentials creds) {
		Session s = factory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(creds);
		tx.commit();
	}
	
	@Override
	public Student getUserbyUnameAndPword(String user, String pass) {
		//initialize variables 
		Integer loginCredsId = 0; 
		Student stu = null;
		//
		try (Session s = factory.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			// query 1
			Query q1 = s.getNamedQuery("returnCredentialsId");
			q1.setParameter("userVar", user);
			q1.setParameter("passVar", pass);
			//
			List<Integer> loginCredsIdList = q1.getResultList();
			//
			for (Integer id : loginCredsIdList) {
				loginCredsId = id;
			}
			// query 2
			Query q2 = s.getNamedQuery("getUserbyLoginCredsId");
			q2.setParameter("loginCredsVar", loginCredsId);
			//
			List<Student> StudentList = q2.getResultList();
			//
			for (Student s1 : StudentList) {
				stu = s1; 
			}
			tx.commit();
		}
		return stu; 
	}

	@Override
	public void createCreds(Credentials creds) {
		Session s = factory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(creds);		
		tx.commit();
	}
	

}
