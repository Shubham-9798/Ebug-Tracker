package com.Ebug.dao;
import com.Ebug.entity.Customer_Table;
import com.Ebug.entity.Ticket_Table;

public interface Customer_Repository_I {
	boolean register(Customer_Table customer);
	Customer_Table login(String email,String password);
	//boolean raiseTicket(Customer_Ticket ticket);
	//Ticket_Table viewTicket(long ticketId);
	boolean sendTicketDetails(Ticket_Table ticket);
}