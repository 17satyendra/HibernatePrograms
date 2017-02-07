package com.satya.relation.util;

import java.util.Calendar;
import java.util.Date;

import com.satya.relation.dao.CountryDAO;
import com.satya.relation.model.Country;
import com.satya.relation.model.President;

public class Tester {

	public static void main(String[] args) 
	{
		Country c = new Country();
		c.setName("india");
		c.setStates(25);
		c.setCurrency("INR");
		
		President p = new President();
		p.setName("Satyendra Singh");
		p.setGender('m');
		p.setDoj(getDate());
		p.setAge(25);
		
		//relation one to one
		c.setPresident(p);
		p.setCountry(c);
		
		CountryDAO dao = new CountryDAO();
		dao.saveCountry(c);
	}

	public static Date getDate() 
	{
		Calendar cal = Calendar.getInstance();
		cal.set(cal.YEAR, 2013);
		cal.set(cal.MONTH, cal.JUNE);
		cal.set(cal.DATE, 30);
		Date date = cal.getTime();
		return date;
	}
	 
}
