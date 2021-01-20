package com.Ebug.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ebug.entity.Customer_Table;
import com.Ebug.entity.Ticket_Table;

@Repository
public interface Customer_Repository extends JpaRepository<Customer_Table, Long> {
	
	@Query(value = "select c from Customer_Table c where c.emailId=:emailId and c.password=:password" )
	Customer_Table login(String emailId,String password);
	
	@Query(value = "select t from Ticket_Table t where t.id=:id")
	Ticket_Table viewTicketById(long id);

}
