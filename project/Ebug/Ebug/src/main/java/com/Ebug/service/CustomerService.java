package com.Ebug.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Ebug.dao.Customer_Repository;
import com.Ebug.dao.Ticket_Repository;
import com.Ebug.entity.Customer_Table;
import com.Ebug.entity.Ticket_Table;
import com.Ebug.exception.EbugException;
import com.Ebug.exception.TicketNotFoundException;

@Service
@Transactional
public class CustomerService implements ICustomerService {
	@Autowired
	private Customer_Repository customerRepository;
	
	@Autowired
	private Ticket_Repository ticketRepository;
	

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
	public Customer_Table register(Customer_Table customer) {

		try {
			List<Customer_Table> customersList = customerRepository.findAll();
			for(Customer_Table isExists : customersList) {
				if(isExists.getEmailId().equalsIgnoreCase(customer.getEmailId())) {
					throw new EbugException("Customer already Exists");
				}
			}
			return customerRepository.save(customer);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Customer_Table login(String emailId, String password) {
		return customerRepository.login(emailId, password);
	}

	@Override
	public Ticket_Table viewTicketById(Long id) {
		try {
			Optional<Ticket_Table> data = ticketRepository.findTicketById(id);
			if(data.isPresent())
				return data.get();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return null;
	}
	
	@Override
	public List<Ticket_Table> getTicketByCriticalLevelIdByCus(Long criticalId,Long employeeId) 
	{
			List<Ticket_Table> ticketList = ticketRepository.FindTicketByCriticalLevelIdByEmp(criticalId,employeeId);
			if(ticketList.size() == 0) {
				throw new TicketNotFoundException("There is no ticket available for the critical level id: "+criticalId, "200");
			} else {
				return ticketList;
			}
	}
	
	@Override
	public List<Ticket_Table> getTicketByStatusByCus(Long statusId,Long employeeId)
	{
			List<Ticket_Table> ticketList = ticketRepository.FindTicketByStatusIdByEmp(statusId,employeeId);
			if(ticketList.size() == 0) {
				throw new TicketNotFoundException("There is no ticket available for the status id: "+statusId, "400");
			} else {
				return ticketList;
			}
	}
	
	
	
	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}
	
	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}



}
