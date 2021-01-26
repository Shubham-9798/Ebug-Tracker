package com.Ebug.service;

import java.util.List;

import com.Ebug.dto.TicketDtoForEmploye;
import com.Ebug.entity.CriticalLevel_Table;
import com.Ebug.entity.Employee_Table;
import com.Ebug.entity.Status_Table;
import com.Ebug.entity.Ticket_Table;

public interface IEmplyeeService {

    Status_Table addStatus(Status_Table status);
    
    CriticalLevel_Table addCriticalLevel(CriticalLevel_Table critical);
    
    Employee_Table login(String emailId, String password);
    
    List<Ticket_Table> getTicketByStatus(Long statusId, Long employeeId);
    
	List<Ticket_Table> getTicketByCriticalLevelId(Long criticalId, Long employeeId);

	List<Ticket_Table> getTicketByProjectId(Long projectId, Long employeeId);
	List<Ticket_Table> getAssignedTickets(Long cusId);
	
	Ticket_Table sendSolutionToCustomer(TicketDtoForEmploye ticketDto);
	
	Ticket_Table assignTaskToOtherEmployee(TicketDtoForEmploye ticketDto);
	
	List<Employee_Table> getEmpList();
}
