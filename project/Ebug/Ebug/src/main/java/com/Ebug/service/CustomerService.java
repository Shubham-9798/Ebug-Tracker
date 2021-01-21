package com.Ebug.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ebug.dao.Customer_Repository;
import com.Ebug.dao.Ticket_Repository;
import com.Ebug.entity.Customer_Table;
import com.Ebug.entity.Ticket_Table;
import com.Ebug.exception.EbugException;

@Service
@Transactional
public class CustomerService implements ICustomerService {
	@Autowired
	private Customer_Repository customerRepository;
	
	@Autowired
	private Ticket_Repository ticketRepository;
	

//	
	@Override
	public Ticket_Table createTicket(Ticket_Table ticket) {
		// TODO Auto-generated method stub
		try {
			return ticketRepository.save(ticket);
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
		
	}
	
	@Override
	public Customer_Table register(Customer_Table customer) {

		try {
			List<Customer_Table> customersList = customerRepository.findAll();
			for(Customer_Table isExists : customersList) {
				if(isExists.getEmailId().equalsIgnoreCase(customer.getEmailId())) {
					throw new EbugException("Customer already Exists");
				}
			}
			return customerRepository.save(customer);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Customer_Table login(String emailId, String password) {
		return customerRepository.login(emailId, password);
	}

	@Override
	public Ticket_Table viewTicketById(Long id) {
		try {
			Optional<Ticket_Table> data = ticketRepository.findTicketById(id);
			if(data.isPresent())
				return data.get();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return null;
	}
}
