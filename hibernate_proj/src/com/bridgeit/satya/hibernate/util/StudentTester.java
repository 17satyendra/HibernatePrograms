package com.bridgeit.satya.hibernate.util;

import com.bridgeit.satya.hibernate.dao.StudentDAO;
import com.bridgeit.satya.hibernate.dto.StudentDTO;

public class StudentTester {

	public static void main(String[] args) 
	{
		StudentDTO dto = new StudentDTO();
		
		dto.setId(2);
		dto.setName("adxc sdfkj");
		dto.setAge(15);
		dto.setSex("male");
		dto.setAddress("mumbai");
		
		StudentDAO dao = new StudentDAO();
		dao.saveStudent(dto);
		System.out.println("data saved...");
				
	}

}
