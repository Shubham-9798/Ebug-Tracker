package com.Ebug.service;

import java.util.List;

import com.Ebug.entity.Ticket_Table;

public interface IAdminService {

	 List<Ticket_Table> getAllTickets();
	 Ticket_Table createTicket(Ticket_Table ticket);
}
