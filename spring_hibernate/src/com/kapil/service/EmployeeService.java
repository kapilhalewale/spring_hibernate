package com.kapil.service;

import java.io.Serializable;
import java.util.List;
import com.kapil.domain.Employee;


public interface EmployeeService extends Serializable
{
	public void saveUpdateEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Employee getEmployee(int id);
	public void dropEmployee(int id);
}
