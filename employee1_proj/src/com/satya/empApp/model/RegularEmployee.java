package com.satya.empApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("regularemployee")  
public class RegularEmployee extends Employee implements Serializable
{
	@Column
	private float salary;
	@Column
	private int bonus;
	public RegularEmployee() {
		System.out.println(this.getClass().getSimpleName()+"Created..");// TODO Auto-generated constructor stub
	}
	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}
	/**
	 * @return the bonus
	 */
	public int getBonus() {
		return bonus;
	}
	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
