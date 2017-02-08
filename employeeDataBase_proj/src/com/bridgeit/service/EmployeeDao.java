package com.bridgeit.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.bridgeit.model.EmployeeDTO;
import com.satya.sessionjar.SessionUtil;

public class EmployeeDao 
{
	public EmployeeDao() {
		System.out.println(this.getClass().getSimpleName()+" Created..");
	}
	
	public void saveData(EmployeeDTO dto)
	{
		System.out.println("Data saving...");
		
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = null;
		
		try {
			tx= session.beginTransaction();
			session.save(dto);
			tx.commit();
		} catch (HibernateException he) 
		{
			he.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public EmployeeDTO /*List<EmployeeDTO>*/ getEmployeeInfo()
	{
		System.out.println("Data saving...");
		
		Session session = SessionUtil.getFactory().openSession();
		List<EmployeeDTO> list = null;
		
		EmployeeDTO product=null;
		try {
			
			//To obtain a unique result from the result set, use this code:
			Criteria c2 = session.createCriteria(EmployeeDTO.class);
			c2.add(Restrictions.le("salary",new Double(8000.0)));
			c2.setMaxResults(1);
			product=(EmployeeDTO)c2.uniqueResult();
			
			
		} catch (HibernateException he) 
		{
			he.printStackTrace();
		}finally{
			session.close();
		}
		return product;
	}
	public List<EmployeeDTO> getList()
	{
		System.out.println("Data saving...");
		
		Session session = SessionUtil.getFactory().openSession();
		List<EmployeeDTO> list = null;
		
		try {
			Criteria c1 = session.createCriteria(EmployeeDTO.class);
			/*The result is sort by ‘date’ in ascending order.
			c1.addOrder(Order.asc("salary"));
			
			The result is sort by ‘date’ in descending order.
			c1.addOrder(Order.desc("name"));
			
			Make sure the valume is equal to 10000
			c1.add(Restrictions.eq("salary", new Double(75000.0)));
			*/
			//To obtain a List list from the result set max result, use this code
			c1.add(Restrictions.le("salary",new Double(75000.0)));
			c1.setMaxResults(3);
			
			list = c1.list();
			
			
			
		} catch (HibernateException he) 
		{
			he.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
}
