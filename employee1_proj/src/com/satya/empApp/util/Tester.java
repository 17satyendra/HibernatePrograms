package com.satya.empApp.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satya.empApp.dao.EmployeeDAO;
import com.satya.empApp.model.ContractEmployee;
import com.satya.empApp.model.Employee;
import com.satya.empApp.model.RegularEmployee;
import com.satya.sessionjar.SessionUtil;

public class Tester {

	public static void main(String[] args) {
		Session session = SessionUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		Employee e1 = new Employee();
		e1.setName("sonoo");

		RegularEmployee e2 = new RegularEmployee();
		e2.setName("Vivek Kumar");
		e2.setSalary(50000);
		e2.setBonus(5);

		ContractEmployee e3 = new ContractEmployee();
		e3.setName("Arjun Kumar");
		e3.setPay_per_hour(1000);
		e3.setContract_period("15 hours");

		session.save(e1);
		session.save(e2);
		session.save(e3);
		
		tx.commit();
		session.close();
		

		System.out.println("Done");
	}

}
