package com.satya.empApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("contractemployee")  
public class ContractEmployee extends Employee implements Serializable
{
	@Column
	private float pay_per_hour;
	@Column
	private String contract_period;
	public ContractEmployee() {
		System.out.println(this.getClass().getSimpleName()+"Created..");
	}
	/**
	 * @return the pay_per_hour
	 */
	public float getPay_per_hour() {
		return pay_per_hour;
	}
	/**
	 * @param pay_per_hour the pay_per_hour to set
	 */
	public void setPay_per_hour(float pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}
	/**
	 * @return the contract_period
	 */
	public String getContract_period() {
		return contract_period;
	}
	/**
	 * @param contract_period the contract_period to set
	 */
	public void setContract_period(String contract_period) {
		this.contract_period = contract_period;
	}
	
}
