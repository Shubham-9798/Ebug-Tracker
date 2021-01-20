package com.Ebug.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ebug.dao.CriticalLevel_Repository;
import com.Ebug.dao.Employee_Repositroy;
import com.Ebug.dao.Status_Repository;
import com.Ebug.entity.CriticalLevel_Table;
import com.Ebug.entity.Employee_Table;
import com.Ebug.entity.Status_Table;

@Service
public class EmployeeService implements IEmplyeeService {

	@Autowired
	private Status_Repository statusRepository;
	@Autowired
	private CriticalLevel_Repository criticalRepository;
	@Autowired
	private Employee_Repositroy employeeRepository;
	
	@Override
	public Status_Table addStatus(Status_Table status) {
		// TODO Auto-generated method stub
		return statusRepository.save(status);
	}
	
	@Override
	public CriticalLevel_Table addCriticalLevel(CriticalLevel_Table critical) {
		// TODO Auto-generated method stub
		return criticalRepository.save(critical);
	}

	@Override
	public Employee_Table login(String emailId, String password) {
		// TODO Auto-generated method stub
		 return employeeRepository.login(emailId, password);
	}
}
