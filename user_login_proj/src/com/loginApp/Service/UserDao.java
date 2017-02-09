package com.loginApp.Service;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.loginApp.model.User;
import com.satya.sessionjar.SessionUtil;

public class UserDao 
{
	public UserDao() 
	{
		System.out.println(this.getClass().getSimpleName()+" Created..");
	}
	public void save (User user)
	{
		System.out.println("Data Saving...");
		Configuration cf=new Configuration();
		Session sess=cf.buildSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		
		
			try {
				sess.save(user);
				tx.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				
				if(sess!=null){
					sess.close();;
				}
			}
	
	}
	public User fetchByName(String name)
	{
		System.out.println("Data Fetching...");

		String hql = "* from User b where b.user_id=:name";
		Configuration cf=new Configuration();
		Session sess=cf.buildSessionFactory().openSession();
		
		try{
			Query query = sess.createQuery(hql);
			query.setParameter("name", name);
			User fromDB = (User)query.uniqueResult();
			return fromDB;
		}
		finally {
			sess.close();
		}
	}
	
}
