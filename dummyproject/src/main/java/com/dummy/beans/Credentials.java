package com.dummy.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
	
	@NamedQuery(
				name = "returnCredentialsId", 
				query = "select id from Credentials where username = :userVar and password = :passVar")
})


@Entity
@Table(name = "Credentials")
public class Credentials {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="Creds")
    @Column(name = "Credentials_id")
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	// Constructors
	public Credentials() {
		
	}
	
	public Credentials(String user , String pass) {
		this.username=user;
		this.password=pass;
	}

	//getters/setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "Credentials [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
