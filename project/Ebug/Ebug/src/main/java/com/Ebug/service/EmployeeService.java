package com.Ebug.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ebug.dao.CriticalLevel_Repository;
import com.Ebug.dao.Employee_Repositroy;
import com.Ebug.dao.Status_Repository;
import com.Ebug.dao.Ticket_Repository;
import com.Ebug.dto.TicketDtoForEmploye;
import com.Ebug.entity.CriticalLevel_Table;
import com.Ebug.entity.Employee_Table;
import com.Ebug.entity.Status_Table;
import com.Ebug.entity.Ticket_Table;
import com.Ebug.exception.TicketNotFoundException;

@Service
@Transactional
public class EmployeeService implements IEmplyeeService {

	
	@Autowired
	private Ticket_Repository ticketRepository;
	@Autowired
	private Status_Repository statusRepository;
	@Autowired
	private CriticalLevel_Repository criticalRepository;
	@Autowired
	private Employee_Repositroy employeeRepository;
	
	@Override
	public Status_Table addStatus(Status_Table status) {
		// TODO Auto-generated method stub
		return statusRepository.save(status);
	}
	
	@Override
	public CriticalLevel_Table addCriticalLevel(CriticalLevel_Table critical) {
		// TODO Auto-generated method stub
		return criticalRepository.save(critical);
	}

	@Override
	public Employee_Table login(String emailId, String password) {
		// TODO Auto-generated method stub
		 return employeeRepository.login(emailId, password);
	}
	
	@Override
	public List<Ticket_Table> getTicketByStatus(Long statusId,Long employeeId)
	{
			List<Ticket_Table> ticketList = ticketRepository.FindTicketByStatusIdByEmp(statusId,employeeId);
			if(ticketList.size() == 0) {
				throw new TicketNotFoundException("There is no ticket available for the status id: "+statusId, "400");
			} else {
				return ticketList;
			}
	}
	
	@Override
	public List<Ticket_Table> getTicketByCriticalLevelId(Long criticalId,Long employeeId) 
	{
			List<Ticket_Table> ticketList = ticketRepository.FindTicketByCriticalLevelIdByEmp(criticalId,employeeId);
			if(ticketList.size() == 0) {
				throw new TicketNotFoundException("There is no ticket available for the critical level id: "+criticalId, "200");
			} else {
				return ticketList;
			}
	}
	
	@Override
	public List<Ticket_Table> getTicketByProjectId(Long projectId,Long employeeId) 
	{
			List<Ticket_Table> ticketList = ticketRepository.FindTicketByProjectIdByEmp(projectId,employeeId);
			if(ticketList.size() == 0) {
				throw new TicketNotFoundException("There is no ticket available for the project id: "+projectId, "401");
			} else {
				return ticketList;
			}
	}

	@Override
	public Ticket_Table sendSolutionToCustomer(TicketDtoForEmploye ticketDto) {
		try {
			Optional<Ticket_Table> data = ticketRepository.findById(ticketDto.getTicketId());
			if(data.isPresent())
			{
				Ticket_Table ticket = data.get();
				ticket.setSolution(ticketDto.getSolution());
				return ticketRepository.save(ticket);
			}
			else {
				return null;
			}
		} catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	@Override
	public Ticket_Table assignTaskToOtherEmployee(TicketDtoForEmploye ticketDto) {
		try {
			Optional<Ticket_Table> data = ticketRepository.findById(ticketDto.getTicketId());
			if(data.isPresent())
			{
				Ticket_Table ticket = data.get();
				System.out.println("data");
				ticket.setAssignedToEmployee(ticketDto.getAssignedId());
				return ticketRepository.save(ticket);
			}
			else {
				return null;
			}
		} catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
//		return null;
	}

	@Override
	public List<Ticket_Table> getAssignedTickets(Long cusId) {
		List<Ticket_Table> ticketList = ticketRepository.FindAllTicketAssignedToEmp(cusId);
		
		if(ticketList.size() == 0) {
			throw new TicketNotFoundException("There is no ticket available for the project id: ", "401");
		} else {
			return ticketList;
		}
	}
}
