package com.kapil.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.kapil.dao.UserDao;
import com.kapil.domain.User;

public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String email)		throws UsernameNotFoundException
	{
		User user = userDao.getUserbyMail(email);
		if(user == null)
		{
			throw new UsernameNotFoundException("User Not found");
		}
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
                true, true, true, true, getGrantedAuthorities(user));
	}

	 private List<GrantedAuthority> getGrantedAuthorities(User user)
	 {
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	  /*      for(UserType userType : user.getUserTypes())
	        {
	            System.out.println("UserType : {}" +userType);
	            authorities.add(new SimpleGrantedAuthority("ROLE_"+userType.getCode()));
	        }*/
            System.out.println("authorities : {}" +authorities);
	        return authorities;
	    }
}
