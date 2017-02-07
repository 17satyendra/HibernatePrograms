package com.satya.empApp.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satya.empApp.model.Employee;
import com.satya.sessionjar.SessionUtil;

public class EmployeeDAO
{
	public EmployeeDAO() {
		System.out.println(this.getClass().getSimpleName()+"Created");
	}
	
	public void saveEmp(Employee e)
	{
		System.out.println("Data Saving .....");
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(e);
		tx.commit();
		session.close();
	}
	public Employee fetchByName(String name)
	{
		String hql ="select e from Employee e where e.name='"+name+"'";
		Session session = SessionUtil.getFactory().openSession();
		
		try{
			Query query = session.createQuery(hql);
			Employee fromDB =(Employee) query.uniqueResult();
			return fromDB;
		}finally {
			session.close();
		}
	}
}
