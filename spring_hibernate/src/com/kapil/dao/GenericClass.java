package com.kapil.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	public List<Object> getObjectList(Object object) 
	{
		  Session session = getSessionFactory().openSession();
		List<Object> objectList;
		try{
			
			  Transaction tx = session.beginTransaction();  
			  Query query = session.createQuery("FROM  "+object);
			  objectList = query.list();		  
			  tx.commit();
		}finally
		{
			session.close();
		}
		return objectList;
	}

	public Object getObject(Object object, int id) 
	{
		  Session session = getSessionFactory().openSession();
		  Object returnObject;
		  try{
			  
			  session.beginTransaction();  
			   returnObject =  (Object) session.get(Object.class, id);
		  }
		 finally
		 {
			 session.close();
		 }

		  return returnObject;
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
