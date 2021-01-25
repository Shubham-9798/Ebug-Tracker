package com.Ebug.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.Ebug.entity.Customer_Table;
import com.Ebug.entity.Ticket_Table;

public interface ICustomerService {


	Customer_Table register(Customer_Table customer);
	  Customer_Table login(String emailId,String password);
	  Ticket_Table viewTicketById(Long id);
		Ticket_Table createTicket(Ticket_Table ticket);
		
	    List<Ticket_Table> getTicketByStatusByCus(Long statusId, Long employeeId);
	    
		List<Ticket_Table> getTicketByCriticalLevelIdByCus(Long criticalId, Long employeeId);
	}
