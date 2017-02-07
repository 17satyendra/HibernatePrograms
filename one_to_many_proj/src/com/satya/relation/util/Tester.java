package com.satya.relation.util;

import java.util.ArrayList;
import java.util.Collection;

import com.satya.relation.model.Game;
import com.satya.relation.model.Mobile;
import com.satya.relation.service.MobileDAO;

public class Tester 
{
	public static void main(String[] args) {
		
		Mobile m = new Mobile();
		m.setBrand("mapple");
		m.setOs("soi");
		m.setPrice(50000.0);
		
		Game g1 = new Game();
		g1.setName("hello world");
		g1.setLevel(10);
		g1.setType("Common");
		
		Game g2 = new Game();
		g2.setName("temple run");
		g1.setLevel(20);
		g1.setType("Advantures");
		
		Collection<Game> collection = new ArrayList<Game>();
		collection.add(g1);
		collection.add(g2);
		m.setGame(collection);
		
		MobileDAO dao = new MobileDAO();
		dao.saveMobile(m);
		
		System.out.println("Data Saved..");
	}
}
