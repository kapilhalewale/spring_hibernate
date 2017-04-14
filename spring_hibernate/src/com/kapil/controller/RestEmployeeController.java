package com.kapil.controller;
/*
 *  Author : H Kapil Kumar;
 * Rest Spring Controller class to map the related actions
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kapil.dao.EmployeeDao;
import com.kapil.domain.Employee;

@RestController
@RequestMapping("/employee")
public class RestEmployeeController
{
	@Autowired
	private EmployeeDao employeeDao;
	
	//produces json response
	@GetMapping(value="/rest-employee-json", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>>  employee_json_response()
	{
		return  new ResponseEntity<List<Employee>>(employeeDao.getEmployees(), HttpStatus.OK);
	}

	//produces xml response
	@GetMapping(value="/rest-employee-xml", produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<Employee>>  employee_xml_response()
	{
		return  new ResponseEntity<List<Employee>>(employeeDao.getEmployees(), HttpStatus.OK);
	}
}