package com.kapil.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="user")
public class User
{
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_entities", joinColumns = { @JoinColumn(name = "user_id") },      inverseJoinColumns = { @JoinColumn(name = "entity_id") })
    private Set<Entity> userEntities = new HashSet<Entity>();

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	
    @Column(nullable=false)
	private String name;

    @Column(name="username", unique=true, nullable=false)
	private String email;

    @Column(name="password", nullable=false)
	private String password;

    @Column(name="createdOn", nullable=false)
	private Date createdOn;
 
	@ManyToOne
	private UserType userType;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Entity> getUserEntities() {
		return userEntities;
	}

	public void setUserEntities(Set<Entity> userEntities) {
		this.userEntities = userEntities;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}