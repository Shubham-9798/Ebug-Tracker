package com.Ebug.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class CriticalLevel_Table {
	
	@Id
	private Long id;
	
	private String type;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "criticalLevel")
	private List<Ticket_Table> tickets = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Ticket_Table> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket_Table> tickets) {
		this.tickets = tickets;
	}

	public CriticalLevel_Table(Long id, String type, List<Ticket_Table> tickets) {
		super();
		this.id = id;
		this.type = type;
		this.tickets = tickets;
	}

	public CriticalLevel_Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
