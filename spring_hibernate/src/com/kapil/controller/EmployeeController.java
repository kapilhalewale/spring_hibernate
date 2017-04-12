package com.kapil.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kapil.dao.EmployeeDao;
import com.kapil.domain.Employee;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController extends CommonController
 {
	@Autowired
	private EmployeeDao employeeDao;
	
    @RequestMapping(value= "/employees")    
    public String employees(ModelMap model)
    {
        model.addAttribute("employees", employeeDao.getEmployees());
        return "employee_list";
    }
 
    @RequestMapping(value= "/add-employee")    
    public String addEmployee(@ModelAttribute("employee") Employee employee, ModelMap model)
    {
        model.addAttribute("entities", employeeDao.getEntities());
    	return "employee_add";
    } 
    
    @RequestMapping(value= "/save-employee", method=RequestMethod.POST)    
    public void saveEmployee(@ModelAttribute("employee") Employee employee, BindingResult result, HttpServletResponse httpServletResponse) throws IOException
    {
    	System.out.println("Employee Dare " +employee.getDateOfJoining());
    	System.out.println("Employee " +employee.getName());
    	employeeDao.saveUpdateEmployee(employee);
    	httpServletResponse.sendRedirect("employees");
    } 
    
	@RequestMapping(value="/edit-employee/{id}", method=RequestMethod.GET)
	public String editEmployee(ModelMap model, @PathVariable("id") int id) 
	{
		model.addAttribute("entities", employeeDao.getEntities());
		model.addAttribute("employee", employeeDao.getEmployee(id));
    	return "employee_add";
	}
	
	  @RequestMapping(value= "/drop-employee/{id}", method=RequestMethod.GET)    
	    public void dropEmployee(HttpServletResponse httpServletResponse,  @PathVariable("id") int id) throws IOException
	    {
	    	employeeDao.dropEmployee(id);
	    	httpServletResponse.sendRedirect(getBasePath()+"/employee/employees");
	    } 
}

