package com.Ebug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	@PostMapping("/createticket")
	ResponseEntity<Ticket_Table> createTickets(@RequestBody Ticket_Table ticket) {
		System.out.println(ticket.toString());
		
	    return new ResponseEntity<Ticket_Table>(adminService.createTicket(ticket), HttpStatus.OK);
//		return null;
	}
}
