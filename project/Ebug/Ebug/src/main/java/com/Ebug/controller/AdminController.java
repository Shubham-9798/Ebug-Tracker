package com.Ebug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Ebug.entity.CriticalLevel_Table;
import com.Ebug.entity.Project_Table;
import com.Ebug.entity.Status_Table;
import com.Ebug.entity.Ticket_Table;
import com.Ebug.service.IAdminService;

@Controller
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@GetMapping("/tickets")
	ResponseEntity<List<Ticket_Table>> getAllTickets() {
	    return new ResponseEntity<List<Ticket_Table>>(adminService.getAllTickets(), HttpStatus.OK);
	}
	
	@GetMapping("/ticket/{id}")
	ResponseEntity<List<Ticket_Table>> getAllTickets1(@PathVariable("id") Long id) {
	    return new ResponseEntity<List<Ticket_Table>>(adminService.getTicketByStatusId(id), HttpStatus.OK);
	}
	
	@GetMapping("/getstatus")
	ResponseEntity<List<Status_Table>> getAllStatus() {
	    return new ResponseEntity<List<Status_Table>>(adminService.getAllStatus(), HttpStatus.OK);
	}
	
	@PostMapping("/createticket")
	ResponseEntity<Ticket_Table> createTickets(@RequestBody Ticket_Table ticket) {
		System.out.println(ticket.toString());
	    return new ResponseEntity<Ticket_Table>(adminService.createTicket(ticket), HttpStatus.OK);
	}
	
	@PostMapping("/updateticket")
	ResponseEntity<Ticket_Table> updateTickets(@RequestBody Ticket_Table ticket) {
		System.out.println(ticket.toString());
	    return new ResponseEntity<Ticket_Table>(adminService.createTicket(ticket), HttpStatus.OK);
	}
	
	@PostMapping("/addstatus")
	ResponseEntity<Status_Table> createTickets(@RequestBody Status_Table status) {
	    return new ResponseEntity<Status_Table>(adminService.addStatus(status), HttpStatus.OK);
	}
	
	@PostMapping("/addcritical")
	ResponseEntity<CriticalLevel_Table> createTickets(@RequestBody CriticalLevel_Table critical) {
	    return new ResponseEntity<CriticalLevel_Table>(adminService.addCriticalLevel(critical), HttpStatus.OK);
	}
	
	@GetMapping("/getcritical")
	ResponseEntity<List<CriticalLevel_Table>> getAllCritical() {
	    return new ResponseEntity<List<CriticalLevel_Table>>(adminService.getAllCritical(), HttpStatus.OK);
	}
	
	// Project
	@PostMapping("/createproject")
	ResponseEntity<Project_Table> createTickets(@RequestBody Project_Table project) {
	    return new ResponseEntity<Project_Table>(adminService.addProject(project), HttpStatus.OK);
	}
	
	@GetMapping("/getproject")
	ResponseEntity<List<Project_Table>> getAllProject() {
	    return new ResponseEntity<List<Project_Table>>(adminService.getAllProject(), HttpStatus.OK);
	}
	
	@GetMapping("/getproject/{id}")
	ResponseEntity<Project_Table> getProjectByID(@PathVariable("id") Long id) {
	    return new ResponseEntity<Project_Table>(adminService.getProjectByID(id), HttpStatus.OK);
	}
}
