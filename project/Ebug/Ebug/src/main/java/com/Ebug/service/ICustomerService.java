package com.Ebug.service;

import com.Ebug.entity.Customer_Table;
import com.Ebug.entity.Ticket_Table;

public interface ICustomerService {


	Customer_Table register(Customer_Table customer);
	Customer_Table login(String emailId,String password);
	Ticket_Table viewTicketById(Long id);
		Ticket_Table createTicket(Ticket_Table ticket);
	}
