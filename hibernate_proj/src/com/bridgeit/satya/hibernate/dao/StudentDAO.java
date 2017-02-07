package com.bridgeit.satya.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bridgeit.satya.hibernate.dto.StudentDTO;

public class StudentDAO 
{
	public StudentDAO()
	{
		System.out.println(this.getClass().getSimpleName()+" Created...");
	}
	
	public void saveStudent(StudentDTO dto)
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(StudentDTO.class);
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(dto);
		tx.commit();
		
		session.close();
		factory.close();
	}
}
