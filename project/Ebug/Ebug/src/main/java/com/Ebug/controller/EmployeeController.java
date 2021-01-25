package com.Ebug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ebug.dto.TicketDtoForEmploye;
import com.Ebug.entity.CriticalLevel_Table;
import com.Ebug.entity.Employee_Table;
import com.Ebug.entity.Status_Table;
import com.Ebug.entity.Ticket_Table;
import com.Ebug.service.IEmplyeeService;

@Controller
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	IEmplyeeService employeeService;
	
	@PostMapping("/addstatus")
	ResponseEntity<Status_Table> createStatus(@RequestBody Status_Table status) {
	    return new ResponseEntity<Status_Table>(employeeService.addStatus(status), HttpStatus.OK);
	}
	
	@PostMapping("/addcritical")
	ResponseEntity<CriticalLevel_Table> createCriticalLevel(@RequestBody CriticalLevel_Table critical) {
	    return new ResponseEntity<CriticalLevel_Table>(employeeService.addCriticalLevel(critical), HttpStatus.OK);
	}
	
	@PostMapping("/loginEmployee")
	ResponseEntity<Employee_Table> loginEmployee(@RequestBody Employee_Table employee) {
	    return new ResponseEntity<Employee_Table>(employeeService.login(employee.getEmailId(), employee.getPassword()), HttpStatus.OK);
	}
	
	@GetMapping("/ticket/{cusid}")
	ResponseEntity<List<Ticket_Table>> getAssignedTickets(@PathVariable("cusid") Long cusid) {
	    return new ResponseEntity<List<Ticket_Table>>(employeeService.getAssignedTickets(cusid), HttpStatus.OK);
	}
	
	@PutMapping("/assigntickettoOther")
	ResponseEntity<Ticket_Table> assignTicketToEmployeeByAdmin(@RequestBody TicketDtoForEmploye ticketDto) {
		System.out.println(ticketDto.toString());
		return new ResponseEntity<Ticket_Table>(employeeService.assignTaskToOtherEmployee(ticketDto), HttpStatus.OK);
	}
	
	@PutMapping("/sendSolution")
	ResponseEntity<Ticket_Table> sendSolutionToCustomer(@RequestBody TicketDtoForEmploye ticketDto) {
		return new ResponseEntity<Ticket_Table>(employeeService.sendSolutionToCustomer(ticketDto), HttpStatus.OK);
	}
	
	@GetMapping("/ticketbystatusid/{id}/{employeeId}")
	ResponseEntity<List<Ticket_Table>> getTicketsByStatusId(@PathVariable("id") Long id, @PathVariable("employeeId") Long employeeId) {
	    return new ResponseEntity<List<Ticket_Table>>(employeeService.getTicketByStatus(id,employeeId), HttpStatus.OK);
	}
	
	@GetMapping("/ticketbycriticalid/{id}/{employeeId}")
	ResponseEntity<List<Ticket_Table>> getTicketsByCriticalId(@PathVariable("id") Long id,@PathVariable("employeeId") Long employeeId) {
	    return new ResponseEntity<List<Ticket_Table>>(employeeService.getTicketByCriticalLevelId(id,employeeId), HttpStatus.OK);
	}
	
	@GetMapping("/ticketbyprojectid/{id}/{employeeId}")
	ResponseEntity<List<Ticket_Table>> getTicketsByProjectId(@PathVariable("id") Long id,@PathVariable("employeeId") Long employeeId) {
	    return new ResponseEntity<List<Ticket_Table>>(employeeService.getTicketByProjectId(id,employeeId), HttpStatus.OK);
	}
}
