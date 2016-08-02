package com.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmployeePersistor {

	public static void main(String[] args){
		AnnotationConfiguration arc = new AnnotationConfiguration();
		arc.configure();
		SessionFactory sessFactory = arc.buildSessionFactory();
		Session sess = sessFactory.openSession();
		Transaction tx = sess.beginTransaction();
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setEmpName("Satvik");
		sess.save(emp);
		tx.commit();
		sess.close();
		System.out.println("Done");
	}
}
