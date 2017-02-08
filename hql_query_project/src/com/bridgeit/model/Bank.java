package com.bridgeit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table
public class Bank implements Serializable
{
	@Id
	@Column
	@GenericGenerator(name="ref",strategy="increment")
	@GeneratedValue(generator="ref")
	private int id;
	@Column
	private String name;
	@Column
	private String openingDate;
	@Column
	private String chairman;
	@Column
	private String place;
	@Column
	private long contact;
	@Column
	private String source;
	public Bank() {
		System.out.println(this.getClass().getSimpleName()+" Created");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}
	public String getChairman() {
		return chairman;
	}
	public void setChairman(String chairman) {
		this.chairman = chairman;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
