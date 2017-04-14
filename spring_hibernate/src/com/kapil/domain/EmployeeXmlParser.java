package com.kapil.domain;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="employee-info", namespace="com.kapil")
public class EmployeeXmlParser  implements Serializable
{
	private static final long serialVersionUID = 7790124030355957570L;
	
	@JacksonXmlProperty(localName="id", isAttribute=true)
	private int id;
	@JacksonXmlProperty(localName="employee-name")
	private String name;
	@JacksonXmlProperty(localName="employee-code")
	private String code;
	
	@JacksonXmlProperty(localName="employee-salary")
	private BigDecimal salary;
	
	@JacksonXmlProperty(localName="employee-date_of_joining")
	private Date dateOfJoining;
	
	private Entity entity;
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Entity getEntity() {
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
}
