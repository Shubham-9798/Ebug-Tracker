package com.Ebug.service;

import com.Ebug.entity.CriticalLevel_Table;
import com.Ebug.entity.Employee_Table;
import com.Ebug.entity.Status_Table;

public interface IEmplyeeService {

    Status_Table addStatus(Status_Table status);
    
    CriticalLevel_Table addCriticalLevel(CriticalLevel_Table critical);
    
    Employee_Table login(String emailId, String password);
}
