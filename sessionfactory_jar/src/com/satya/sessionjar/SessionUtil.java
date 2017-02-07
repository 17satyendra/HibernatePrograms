package com.satya.sessionjar;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil
{
	private static SessionFactory factory;
	
	public static SessionFactory getFactory()
	{
		System.out.println("calling getfactory");
		return factory;
	}
	static{
		Configuration cfg = new Configuration();
		cfg.configure();
		factory=cfg.buildSessionFactory();
		System.out.println("intialize static SessionFactory");
	}
}
