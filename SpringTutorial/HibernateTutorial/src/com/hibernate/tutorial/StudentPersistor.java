package com.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentPersistor {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory sessFactory = config.buildSessionFactory();
		Session session = sessFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Student st = new Student();
			st.setCourseName("Hibernate");
			st.setStudentName("Madhukar");
			st.setId(1);
			System.out.println(st.toString());
			Integer studentID = (Integer)session.save(st);
			System.out.println("Student ID==>"+studentID);
			tx.commit();
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}finally{
			session.close();
		}
		
	}

}
