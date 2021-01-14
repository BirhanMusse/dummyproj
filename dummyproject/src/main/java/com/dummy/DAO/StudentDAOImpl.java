package com.dummy.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dummy.beans.Student;
import com.dummy.util.HibernateUtil;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public List<Student> getAllStudents() {
		List<Student> stuList = new ArrayList();
	//	stuList.add(new Student("Brian", "Grease", "BG@Gmail.com"));
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		//	 stuList = session.createQuery("from Student", Student.class).list();
		 Session session = HibernateUtil.getSessionFactory().openSession();
			stuList = session.createQuery("from Student", Student.class).list();
			
	
		 


		return stuList;
	}

	@Override
	public void addStudent(Student s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.save(s);
			trans.commit();
		
	}

	@Override
	public boolean updateStudentName(Student s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;
		
	}


}
