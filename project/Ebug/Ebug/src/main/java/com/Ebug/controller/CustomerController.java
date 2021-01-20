package com.Ebug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Ebug.entity.Customer_Table;
import com.Ebug.entity.Ticket_Table;
import com.Ebug.exception.UserAlreadyRegisterd;
import com.Ebug.service.ICustomerService;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	
	@PostMapping(path = "/registerCustomer")
	ResponseEntity<Customer_Table> registerCustomer(@RequestBody Customer_Table customer){
		Customer_Table response = customerService.register(customer);
		if(response == null) {

			throw new UserAlreadyRegisterd("400", "User Alredy Register");			
		}
		 return new ResponseEntity<Customer_Table>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/loginCustomer")
	ResponseEntity<Customer_Table> loginCustomer(@RequestBody Customer_Table customer){
		return new ResponseEntity<Customer_Table>(customerService.login(customer.getEmailId(), 
				customer.getPassword()), HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/viewTicketById")
	ResponseEntity<Ticket_Table> viewTicketById(@RequestBody Ticket_Table ticket){
		return new ResponseEntity<Ticket_Table>(customerService.viewTicketById(ticket.getId()), HttpStatus.OK);
	}
	
	@PostMapping("/createticket")
	ResponseEntity<Ticket_Table> createTickets(@RequestBody Ticket_Table ticket) {
		System.out.println(ticket.toString());
	    return new ResponseEntity<Ticket_Table>(customerService.createTicket(ticket), HttpStatus.OK);
	}
	
    @ExceptionHandler({ UserAlreadyRegisterd.class})
    public ResponseEntity<UserAlreadyRegisterd> handleException(UserAlreadyRegisterd ex) {
        //
    	System.out.println("exception");
    	return new ResponseEntity<UserAlreadyRegisterd>(ex, HttpStatus.OK);
    }
}
