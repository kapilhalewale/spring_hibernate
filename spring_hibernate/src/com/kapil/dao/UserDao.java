package com.kapil.dao;

import java.util.List;
import com.kapil.domain.User;
import com.kapil.domain.UserType;

public interface UserDao
{
	public void saveUpdateUser(User user);
	public List<User> getUsers();
	public List<UserType> getUserTypes();
	public User getUser(int id);
	public User getUserbyMail(String email);
	public void dropUser(int id);
}
