package com.bridgeit.util;

import java.util.List;

import com.bridgeit.model.Bank;
import com.bridgeit.service.BankDAO;

public class Tester {

	public static void main(String[] args)
	{
		/*Bank b  = new Bank();
		b.setName("ICICI");
		b.setOpeningDate("1 april 1990");
		b.setChairman("Chanda Kochhar");
		b.setContact(14525841);
		b.setPlace("India");
		b.setSource("News");
		*/
		BankDAO dao = new BankDAO();
		//dao.saveBank(b);
		//System.out.println("Data Saved...");
		Bank bank=dao.fetchByName("Punjab National Bank");
		System.out.println(bank.getChairman());
		
		System.out.println(dao.getContactByName("Punjab National Bank"));
		
		Object[] arr= dao.getIDAndLocationByName("State Bank Of India");
		System.out.println("id-"+arr[0]);
		System.out.println("location-"+arr[1]);
		
		List<Bank> list = dao.getList();
		for (Bank bank2 : list) 
		{
			System.out.println(bank2.getName());
		}
		
		dao.updateLocationByName("HDFC");
		
		System.out.println(dao.deleteBankById(5)+ " bank data deleted");
	}
	
	

}
