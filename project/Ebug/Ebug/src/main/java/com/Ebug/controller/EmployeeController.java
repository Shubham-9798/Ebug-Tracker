package com.Ebug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Ebug.entity.CriticalLevel_Table;
import com.Ebug.entity.Employee_Table;
import com.Ebug.entity.Status_Table;
import com.Ebug.service.IEmplyeeService;

@Controller
public class EmployeeController {

	@Autowired
	IEmplyeeService employeeService;
	
	@PostMapping("/addstatus")
	ResponseEntity<Status_Table> createTickets(@RequestBody Status_Table status) {
	    return new ResponseEntity<Status_Table>(employeeService.addStatus(status), HttpStatus.OK);
	}
	
	@PostMapping("/addcritical")
	ResponseEntity<CriticalLevel_Table> createTickets(@RequestBody CriticalLevel_Table critical) {
	    return new ResponseEntity<CriticalLevel_Table>(employeeService.addCriticalLevel(critical), HttpStatus.OK);
	}
	
	@PostMapping("/loginEmployee")
	ResponseEntity<Employee_Table> loginEmployee(@RequestBody Employee_Table employee) {
	    return new ResponseEntity<Employee_Table>(employeeService.login(employee.getEmailId(), employee.getPassword()), HttpStatus.OK);
	}
}
