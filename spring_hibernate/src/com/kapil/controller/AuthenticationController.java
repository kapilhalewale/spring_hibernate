package com.kapil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController 
{
	  @RequestMapping(value= "/")    
	    public String defaultPage()
	    {
	        return "login";
	    }
	   @RequestMapping(value= "/login")    
	    public String employees()
	    {
	        return "login";
	    }
	   
	   @RequestMapping(value= "/logout")    
	    public String logout()
	    {
	        return "login";
	    }
}