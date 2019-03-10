package com.company.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save java object
			
			//create the Student object
			System.out.println("Creating a new student object..");
			Student tempStudent = new Student("Paul","Wall","paul@company.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		}
		finally {
			factory.close();
		}
		

	}

}
