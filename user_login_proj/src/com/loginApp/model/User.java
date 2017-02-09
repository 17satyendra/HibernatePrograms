package com.loginApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="user_login")
public class User implements Serializable 
{
	@Id
	@Column
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	private int id;
	@Column
	private String user_id;
	@Column
	private String user_password;
	@Column
	private String user_status;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String user_id, String user_password, String user_status) 
	{
		System.out.println(this.getClass().getSimpleName()+" Created...");
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_status = user_status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
}
