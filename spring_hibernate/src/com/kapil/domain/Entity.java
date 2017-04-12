package com.kapil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table
public class Entity implements Serializable
{
	private static final long serialVersionUID = -8177605505200545692L;
	
	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
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
}
