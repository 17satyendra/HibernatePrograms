package com.bridgeit.satya.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bridgeit.satya.hibernate.dto.StudentDTO;
import com.satya.sessionjar.SessionUtil;

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
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(dto);
		tx.commit();
		
		session.close();
		factory.close();
	}
	public StudentDTO fetchByName(String name)
	{
		String hql ="select e from StudentDTO e where e.name='"+name+"'";
		Session session = SessionUtil.getFactory().openSession();
		
		try{
			Query query = session.createQuery(hql);
			StudentDTO fromDB =(StudentDTO) query.uniqueResult();
			return fromDB;
		}finally {
			session.close();
		}
	}
}
