package com.kapil.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kapil.domain.Employee;
import com.kapil.domain.Entity;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl extends GenericClass implements EmployeeDao
{
	private static final long serialVersionUID = -6705335310919847771L;

	@Override
	public void saveUpdateEmployee(Employee employee)
	{
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		if(session != null)
		{
			session.saveOrUpdate(employee);
			tx.commit();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees()
	{
	 	List<Employee>  list = null;
	 	Session session = getSessionFactory().openSession();
		session.beginTransaction();
		list =session.createCriteria(Employee.class).list();
		session.close();
	return list;
	}

	@Override
	public Employee getEmployee(int id)
	{
		Employee  employee = null;
	 	Session session = getSessionFactory().openSession();
		session.beginTransaction();
		employee = (Employee) session.get(Employee.class, id);
		session.close();
		return employee;
	}

	@Override
	public void dropEmployee(int id)
	{
		if(id > 0)
		{
			dropObject(Employee.class, id);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entity> getEntities()
	{
		 	List<Entity>  entities = null;
		 	Session session = getSessionFactory().openSession();
			session.beginTransaction();
			entities =session.createCriteria(Entity.class).list();
			session.close();
		return entities;
	}
}