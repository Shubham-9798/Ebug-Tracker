package com.Ebug.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Ebug.entity.Customer_Table;
import com.Ebug.entity.Employee_Table;
import com.Ebug.entity.Ticket_Table;

public interface Employee_Repositroy  extends JpaRepository<Employee_Table, Long> {

	@Query(value = "select e from Employee_Table e where e.emailId=:emailId and e.password=:password" )
	Employee_Table login(String emailId,String password);
	
	}
