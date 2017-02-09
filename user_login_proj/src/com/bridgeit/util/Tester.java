package com.bridgeit.util;

import com.loginApp.Service.UserDao;
import com.loginApp.model.User;

public class Tester
{
	public static void main(String[] args) {
		User u = new User("amit","Amit","none");
		UserDao dao = new UserDao();
		dao.save(u);
		System.out.println("Data Saved");
				
	}
}
