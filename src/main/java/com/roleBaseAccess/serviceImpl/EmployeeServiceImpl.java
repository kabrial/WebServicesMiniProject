package com.roleBaseAccess.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roleBaseAccess.model.Employee;
import com.roleBaseAccess.model.EmployeeGraphSalaryName;
import com.roleBaseAccess.repository.EmployeeGraphSalaryNameRepository;
import com.roleBaseAccess.repository.EmployeeRepository;
import com.roleBaseAccess.service.EmployeeService;
/**
 * Class ServiceImpl Country
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    // Repository
    @Autowired
    final EmployeeRepository employeeRepository;
    
    @Autowired
    final EmployeeGraphSalaryNameRepository employeeGraphSalaryNameRepository;
    
    // Constructor
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeGraphSalaryNameRepository employeeGraphSalaryNameRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeGraphSalaryNameRepository = employeeGraphSalaryNameRepository;
    }

    /**
     * find Employee Id
     */
    @Override
    public List<Employee> findEmployeeId(long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    /**
     * Find All Employee
     */
    @Override
    public Iterable<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    /**
     * find one employee
     */
    @Override
    public Employee findEmployee(long employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    /**
     * save a Employee
     */
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    /**
     * search salary and id
     */
    @Override
    public List<EmployeeGraphSalaryName> findIdAndSalary() {

        return employeeGraphSalaryNameRepository.findIdAndSalary();
    }
}
