package com.satya.relation.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table
public class Mobile implements Serializable 
{
	@Id
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	@Column
	private int id;
	@Column
	private String brand;
	@Column
	private double price;
	@Column
	private String os;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="mobile")
	private Collection<Game> game;
	
	public Mobile() {
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
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the os
	 */
	public String getOs() {
		return os;
	}
	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}
	/**
	 * @return the game
	 */
	public Collection<Game> getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(Collection<Game> game) {
		this.game = game;
	}
	
}
