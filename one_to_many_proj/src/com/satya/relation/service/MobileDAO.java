package com.satya.relation.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satya.relation.model.Mobile;
import com.satya.sessionjar.SessionUtil;

public class MobileDAO 
{
	public MobileDAO() {
		System.out.println(this.getClass().getSimpleName()+"Created...");
	}
	
	public void saveMobile(Mobile m)
	{
		System.out.println("data saving ");
		
		Session session = SessionUtil.getFactory().openSession();
		
		Transaction tx=session.beginTransaction();
		try{
			session.save(m);
			tx.commit();
		}catch (Exception e) 
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			session.close();
		}
	}
}
