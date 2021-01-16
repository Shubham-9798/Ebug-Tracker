package com.Ebug.service;

import java.util.List;

import com.Ebug.entity.CriticalLevel_Table;
import com.Ebug.entity.Project_Table;
import com.Ebug.entity.Status_Table;
import com.Ebug.entity.Ticket_Table;

public interface IAdminService {

	 List<Ticket_Table> getAllTickets();
	 Ticket_Table createTicket(Ticket_Table ticket);
	 Ticket_Table updateTicket(Ticket_Table ticket);
     List<Status_Table> getAllStatus() ;
     Status_Table addStatus(Status_Table status);
     
     CriticalLevel_Table addCriticalLevel(CriticalLevel_Table critical);
     List<CriticalLevel_Table> getAllCritical();
     
     Project_Table addProject(Project_Table project);
     List<Project_Table> getAllProject();
     Project_Table getProjectByID(Long id);
	List<Ticket_Table> getTicketByStatusId(Long id);
     
     
     

}
