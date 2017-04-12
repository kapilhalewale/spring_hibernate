package com.kapil.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericClass
{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	protected boolean dropObject(Class<?> obj, Serializable id)
	{
		boolean status;
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	    Object persistentInstance = session.load(obj, id);
	    try
	    {
	    	if (persistentInstance != null)
	    	{
	    		session.delete(persistentInstance);
	    		transaction.commit();
	    		status= true;
	    	}
	    	status= false;
	    }
	    finally
	    {
	    	session.close();
	    }
		return status;
	}
}
