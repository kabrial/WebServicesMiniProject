package com.roleBaseAccess.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.roleBaseAccess.model.Employee;
/**
 * Repository Employee
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByEmployeeId(long employeeId);
 

}