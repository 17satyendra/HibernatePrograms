package com.bridgeit.service;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bridgeit.model.Bank;
import com.satya.sessionjar.SessionUtil;

public class BankDAO
{
	public BankDAO() 
	{
		System.out.println(this.getClass().getSimpleName()+" Created");
	}
	
	public void saveBank(Bank bank)
	{
		System.out.println("Data Fetching...");
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			session.save(bank);
			tx.commit();
		}finally{
			session.close();
		}
	}
	/**
	 * @param name Bank Name 
	 * @return Bank Entity
	 * This method fetch data for Bank type entity using hql query
	 */
	public Bank fetchByName(String name)
	{
		String hql = "select b from Bank b where b.name='"+name+"'";
		Session session = SessionUtil.getFactory().openSession();
		
		try{
			Query query = session.createQuery(hql);
			Bank fromDB = (Bank)query.uniqueResult();
			return fromDB;
		}
		finally {
			session.close();
		}
	}
	/**
	 * @param name-Bank Name 
	 * @return Specific Bank contact number
	 * This method used to get Entity's contact (WrapperClass)
	 */
	public long getContactByName(String name)
	{
		String hql = "select b.contact from Bank b where b.name='"+name+"'";
		Session session = SessionUtil.getFactory().openSession();
		
		try{
			Query query = session.createQuery(hql);
			long cont = (long) query.uniqueResult();
			return cont;
		}
		finally {
			session.close();
		}
	}
	/**
	 * @param name Bank name
	 * @return Array Object.
	 * This method is Used to get id and location in the form of Object Array for perticular Entity Object
	 */
	public Object[] getIDAndLocationByName(String name)
	{
		String hql = "select b.id,b.place from Bank b where b.name='"+name+"'";
		Session session = SessionUtil.getFactory().openSession();
		
		try{
			Query query = session.createQuery(hql);
			Object [] arr=(Object[])query.uniqueResult();
			return arr;
		}
		finally {
			session.close();
		}
	}
	
	/**
	 * @return List of all Entity object 
	 */
	public List <Bank> getList()
	{
		String hql = "select b from Bank b";
		Session session = SessionUtil.getFactory().openSession();
		
		try{
			Query query = session.createQuery(hql);
			List<Bank>list =query.list();
			return list;
		}
		finally {
			session.close();
		}
	}
	/**
	 * @param name bank name
	 * @return how many number of record has been updated.
	 */
	public int updateLocationByName(String name)
	{
		String hql = "update Bank b "+"set b.place='usa'"+"where b.name='"+name+"'";
		System.out.println("Data updating...");
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = null;
		int i=0;
		try{
			tx=session.beginTransaction();
			Query query = session.createQuery(hql);
			i=query.executeUpdate();
			tx.commit();
		}catch (HibernateException he) 
		{
			he.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
		return i;
		
	}
	/**
	 * @param id Bank id 
	 * @return how many number of record has been deleted.
	 */
	public int deleteBankById(int id)
	{
		//String hql = "update Bank b "+"set b.place='usa'"+"where b.name='"+name+"'";
		System.out.println("Data Deleting...");
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = null;
		int result=0;
		try{
			tx=session.beginTransaction();
			Query query = session.createQuery("delete Bank where id ="+id);
			result = query.executeUpdate();
			tx.commit();
			
		}catch (HibernateException he) 
		{
			he.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
		return result;
	}
}
