package com.Ebug.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.Ebug.dao.Ticket_Repository;
import com.Ebug.entity.Ticket_Table;

@Service
@Transactional
public class AdminService implements IAdminService{
	
	private Ticket_Repository ticketRepository;

	@Override
	public List<Ticket_Table> getAllTickets() {
		// TODO Auto-generated method stub
		List<Ticket_Table> ticketList = ticketRepository.findAll();
		
		if(ticketList.size() == 0) {
			return null;
		} else {
			return ticketList;
		}
	}

	@Override
	public Ticket_Table createTicket(Ticket_Table ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}
	
}
