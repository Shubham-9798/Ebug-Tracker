package com.Ebug.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ebug.entity.Ticket_Table;

public interface Ticket_Repository extends JpaRepository<Ticket_Table, Long> {

}
