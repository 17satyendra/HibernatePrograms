package com.satya.relation.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="country")
public class Country implements Serializable
{
	@Id
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int states;
	@Column
	private String currency;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private President president;
	
	public Country() 
	{
		System.out.println(this.getClass().getSimpleName()+"Created..");
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the states
	 */
	public int getStates() {
		return states;
	}

	/**
	 * @param states the states to set
	 */
	public void setStates(int states) {
		this.states = states;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the president
	 */
	public President getPresident() {
		return president;
	}

	/**
	 * @param president the president to set
	 */
	public void setPresident(President president) {
		this.president = president;
	}
	
}
