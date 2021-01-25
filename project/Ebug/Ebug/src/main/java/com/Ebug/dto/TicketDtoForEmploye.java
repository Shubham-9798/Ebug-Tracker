package com.Ebug.dto;

public class TicketDtoForEmploye {
	private Long ticketId;
	private String solution;
	private Long assignedId;
	@Override
	public String toString() {
		return "TicketDtoForEmploye [ticketId=" + ticketId + ", solution=" + solution + ", assignedId=" + assignedId
				+ "]";
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public Long getAssignedId() {
		return assignedId;
	}
	public void setAssignedId(Long assignedId) {
		this.assignedId = assignedId;
	}
	public TicketDtoForEmploye(Long ticketId, String solution, Long assignedId) {
		super();
		this.ticketId = ticketId;
		this.solution = solution;
		this.assignedId = assignedId;
	}
	public TicketDtoForEmploye() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
