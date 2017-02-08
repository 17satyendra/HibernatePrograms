package com.bridgeit.util;

import java.util.Arrays;
import java.util.List;

import com.bridgeit.model.Address;
import com.bridgeit.model.EmployeeDTO;
import com.bridgeit.service.EmployeeDao;

public class Tester {

	public static void main(String[] args) 
	{
		/*EmployeeDTO dto = new EmployeeDTO();
		dto.setName("Ekta Joshi");
		dto.setProfile("hr");
		dto.setDept("HumanResources");
		dto.setContact("9400252046");
		dto.setSalary(15000);
		
		Address add = new Address();
		add.setPermanantAdd("NariyanKheda");
		add.setCity("Indore");
		add.setState("U.P");
		add.setZip(750210);
		
		dto.setAddress(add);
		add.setEmployee(dto);
		*/
		EmployeeDao dao = new EmployeeDao();
		//dao.saveData(dto);
		//System.out.println("Data Saved...");
		
		EmployeeDTO dto=dao.getEmployeeInfo();
		
		System.out.println(dto.getDept());
		
		/*List<EmployeeDTO> res = dao.getList();
		for (EmployeeDTO emp : res) 
		{
			System.out.println(emp.getName());
		}*/
	}

}
