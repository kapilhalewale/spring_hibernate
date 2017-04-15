package com.kapil.controller;
/*
 *  Author : H Kapil Kumar;
 * Spring Controller class to map the related actions
 */
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kapil.dao.EmployeeDao;
import com.kapil.dao.UserDao;
import com.kapil.domain.User;

@Controller
@RequestMapping(value="/user")
public class UserController extends CommonController
 {
	@Autowired
	private UserDao userDao;

	@Autowired
	private EmployeeDao employeeDao;

    @RequestMapping(value= "/users")    
    public String users(ModelMap model)
    {
        model.addAttribute("users", userDao.getUsers());
        System.out.println("Users "+userDao.getUsers());
        return "user_list";
    }
 
    @RequestMapping(value= "/add-user")    
    public String addUser(@ModelAttribute("user") User user, ModelMap model)
    {
	        model.addAttribute("userTypes", userDao.getUserTypes());
	        model.addAttribute("entities", employeeDao.getEntities());
    	return "user_add";
    } 
    
    @RequestMapping(value= "/save-user", method=RequestMethod.POST)    
    public void saveEmployee(@ModelAttribute("user") User user, BindingResult result, HttpServletResponse httpServletResponse) throws IOException
    {
    	user.setCreatedOn(new Date());
    	userDao.saveUpdateUser(user);
    	httpServletResponse.sendRedirect("users");
    } 
}