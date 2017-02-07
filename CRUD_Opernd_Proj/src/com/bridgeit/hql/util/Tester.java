package com.bridgeit.hql.util;

import com.bridgeit.hql.model.Population;
import com.bridgeit.hql.service.PopulationDAO;

public class Tester {

	public static void main(String[] args) 
	{
		/*Population pop = new Population();
		pop.setCountry("china");
		pop.setCurrency("Renminbi");
		pop.setPopulation(1381390000);
		pop.setDateofUpdate("February 6, 2017");
		pop.setPercofWorld("18.5%");
		pop.setSource("Official population clock#");
		
		*/
		PopulationDAO dao = new PopulationDAO();
		//dao.saveModel(pop);
		Population pl=dao.fetchByPk(1);
		/*System.out.println(pl.getCurrency());
		System.out.println(pl.getCountry());
		System.out.println("Data Fetched");
		
		dao.updatePercByRank(4, "5%");
		System.out.println("Data Updated");*/
		
		dao.deleteByRank(4);
		System.out.println("Data Deleted");
		
		
	}

}
