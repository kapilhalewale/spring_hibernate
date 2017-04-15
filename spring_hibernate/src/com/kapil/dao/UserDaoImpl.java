package com.kapil.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.kapil.domain.Employee;
import com.kapil.domain.User;
import com.kapil.domain.UserType;

@Repository("userDao")
public class UserDaoImpl extends GenericClass  implements UserDao
{

	@Override
	public void saveUpdateUser(User user)
	{
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		if(session != null)
		{
			System.out.println("Entities :" +user.getUserEntities().size());
			session.persist(user);
			tx.commit();
			session.close();
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers()
	{
	 	List<User>  list = null;
	 	Session session = getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createCriteria(User.class).list();
		session.close();
		return list;
	}

	@Override
	public User getUser(int id)
	{
		return (User) getObject(new User(), id);
	}

	@Override
	public User getUserbyMail(String email)
	{
		User user= null;
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(session != null)
		{
					user = (User)session.createQuery("From user WHERE user_name = :email")
		           .setString("email", email)
		           .uniqueResult();
			session.close();
		}		
	return user;
	}

	@Override
	public void dropUser(int id)
	{
		if(id > 0)
		{
			dropObject(User.class, id);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserType> getUserTypes()
	{
	 	List<UserType>  list = null;
	 	Session session = getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createCriteria(UserType.class).list();
		session.close();
		return list;
	}

}
