package com.satya.relation.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satya.relation.model.Country;
import com.satya.sessionjar.SessionUtil;

public class CountryDAO
{
	public CountryDAO() 
	{
		System.out.println(this.getClass().getSimpleName()+"created..");
	}
	
	public void saveCountry(Country c)
	{
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(c);
		tx.commit();
		session.close();
	}
}
