package com.bridgeit.hql.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bridgeit.hql.model.Population;
import com.satya.sessionjar.SessionUtil;

public class PopulationDAO 
{
	public PopulationDAO() {
		System.out.println(this.getClass().getSimpleName()+" Created");
	}
	
	public void saveModel(Population pop)
	{
		System.out.println("Data saving...");
		
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(pop);
			tx.commit();
		}catch(HibernateException he){
			he.printStackTrace();
			tx.rollback();
		}
		finally {session.close();}
	}
	public Population fetchByPk(int pk)
	{
		System.out.println("Data Fetching...");
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			Population p = session.get(Population.class, pk);
			return p;
		}finally{
			session.close();
		}
	}
	public void updatePercByRank(int pk , String per)
	{
		System.out.println("Data Updating...");
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			Population p = session.get(Population.class, pk);
			if(p!=null){
				System.out.println("can update");
				p.setPercofWorld(per);
				session.update(p);
			}else{
				System.out.println("can't update");
			}
			tx.commit();
		}finally{
			session.close();
		}
	}
	public void deleteByRank(int rank)
	{
		System.out.println("Data Deleting...");
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			Population p = session.get(Population.class, rank);
			if(p!=null){
				System.out.println("can delete");
				session.delete(p);
			}else{
				System.out.println("can't delete");
			}
			tx.commit();
		}catch(HibernateException he)
		{
			he.printStackTrace();
			System.out.println("Rollbacking....");
			tx.rollback();
		}
		finally{
			session.close();
		}
	}
}
