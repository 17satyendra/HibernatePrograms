package com.bridgeit.hql.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="population")
public class Population implements Serializable
{
	@Id
	@Column
	@GenericGenerator(name="ref",strategy="increment")
	@GeneratedValue(generator="ref")
	private int rank;
	@Column
	private String country;
	@Column
	private String currency;
	@Column
	private long population;
	@Column
	private String dateofUpdate;
	@Column
	private String percofWorld;
	@Column
	private String source;
	
	public Population() {
		System.out.println(this.getClass().getSimpleName()+" Created");
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public String getDateofUpdate() {
		return dateofUpdate;
	}

	public void setDateofUpdate(String dateofUpdate) {
		this.dateofUpdate = dateofUpdate;
	}

	public String getPercofWorld() {
		return percofWorld;
	}

	public void setPercofWorld(String percofWorld) {
		this.percofWorld = percofWorld;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
