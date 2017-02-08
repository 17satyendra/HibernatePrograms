package com.bridgeit.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Address implements Serializable
{
	@Id
	@GenericGenerator(name="ref",strategy="increment")
	@GeneratedValue(generator="ref")
	@Column
	private int id;
	@Column
	private String permanantAdd;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private int zip;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp")
	private EmployeeDTO employee;
	public String getPermanantAdd() {
		return permanantAdd;
	}
	public void setPermanantAdd(String permanantAdd) {
		this.permanantAdd = permanantAdd;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
}
