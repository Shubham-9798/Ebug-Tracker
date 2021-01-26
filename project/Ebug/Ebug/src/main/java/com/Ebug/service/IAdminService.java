package com.Ebug.service;

import java.util.List;

import com.Ebug.entity.CriticalLevel_Table;
import com.Ebug.entity.Customer_Table;
import com.Ebug.entity.Employee_Table;
import com.Ebug.entity.Project_Table;
import com.Ebug.entity.Status_Table;
import com.Ebug.entity.Ticket_Table;

public interface IAdminService {

	 List<Ticket_Table> getAllTickets();
	 
	 List<Ticket_Table> getAllNotAssigendTickets();
	 Ticket_Table getTicketById(Long id);
//	 Ticket_Table createTicket(Ticket_Table ticket);
	 Ticket_Table updateTicketByAdmin(Ticket_Table ticket);
     List<Status_Table> getAllStatus() ;

     List<CriticalLevel_Table> getAllCritical();
     
     Project_Table addProject(Project_Table project);
     List<Project_Table> getAllProject();
     Project_Table getProjectByID(Long id);
	List<Ticket_Table> getTicketByStatusId(Long id);
	List<Ticket_Table> getTicketByCriticalLevelId(Long id);
	List<Ticket_Table> getTicketByProjectId(Long id);
	
	 Ticket_Table assignTicketToEmployeeByAdmin(Long ticketId, Long employeeId);
	 
	 Ticket_Table updateTicketStatusById(Long id);
	 
	 Employee_Table registerEmployee(Employee_Table customer);
     
     
     

}
