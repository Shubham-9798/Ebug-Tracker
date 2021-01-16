package com.Ebug.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Ebug.entity.Ticket_Table;

public interface Ticket_Repository extends JpaRepository<Ticket_Table, Long> {

	@Query(value = "Select * from TICKET_TABLE a where a.status_id=:id",  nativeQuery = true)
	public List<Ticket_Table> FindTicketByStatusId( @Param("id") Long id);
}
