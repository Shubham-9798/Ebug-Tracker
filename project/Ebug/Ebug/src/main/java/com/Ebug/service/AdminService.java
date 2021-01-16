package com.Ebug.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ebug.dao.CriticalLevel_Repository;
import com.Ebug.dao.Project_Repository;
import com.Ebug.dao.Status_Repository;
import com.Ebug.dao.Ticket_Repository;
import com.Ebug.entity.CriticalLevel_Table;
import com.Ebug.entity.Project_Table;
import com.Ebug.entity.Status_Table;
import com.Ebug.entity.Ticket_Table;

@Service
@Transactional
public class AdminService implements IAdminService{
	
	@Autowired
	private Ticket_Repository ticketRepository;
	@Autowired
	private Status_Repository statusRepository;
	@Autowired
	private CriticalLevel_Repository criticalRepository;
	@Autowired
	private Project_Repository projectRepository;
	

	@Override
	public List<Ticket_Table> getAllTickets() {
		// TODO Auto-generated method stub
		List<Ticket_Table> ticketList = ticketRepository.findAll();
		System.out.println(ticketList.get(0).getStatusTable().toString());
		if(ticketList.size() == 0) {
			return null;
		} else {
			return ticketList;
		}
	}
	
	@Override
	public List<Ticket_Table> getTicketByStatusId(Long id) {
		// TODO Auto-generated method stub
		try {
			List<Ticket_Table> ticketList = ticketRepository.FindTicketByStatusId(id);
			if(ticketList.size() == 0) {
				return null;
			} else {
				return ticketList;
			}
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}

	}

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
	public List<Status_Table> getAllStatus() {
		// TODO Auto-generated method stub
		try {
			return statusRepository.findAll();
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
		
	}

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
	public Ticket_Table updateTicket(Ticket_Table ticket) {
		try {
			return ticketRepository.save(ticket);
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	@Override
	public List<CriticalLevel_Table> getAllCritical() {

		return null;
	}

	@Override
	public Project_Table addProject(Project_Table project) {
		// TODO Auto-generated method stub
		try {
			return projectRepository.save(project);
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	@Override
	public List<Project_Table> getAllProject() {
		try {
			return projectRepository.findAll();
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	@Override
	public Project_Table getProjectByID(Long id) {
		try {
			Optional<Project_Table> data = projectRepository.findById(id);
			if(data.isPresent())
			return data.get();
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
		return null;
	}


	
	 
	
}
