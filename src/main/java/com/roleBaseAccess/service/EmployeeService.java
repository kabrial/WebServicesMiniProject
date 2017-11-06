package com.roleBaseAccess.service;

import java.util.List;

import com.roleBaseAccess.model.Employee;
import com.roleBaseAccess.model.EmployeeGraphSalaryName;
/**
 * Interface Service Employee
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface EmployeeService {
    List<Employee> findEmployeeId(long employeeId);
    
    Iterable<Employee> findAllEmployee();
    
    Employee findEmployee(long employeeId);
    
    void saveEmployee(Employee employee);
    
    List<EmployeeGraphSalaryName> findIdAndSalary();
}
