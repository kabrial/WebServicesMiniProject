package com.roleBaseAccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.roleBaseAccess.model.EmployeeGraphSalaryName;


/**
 * Repository EmployeeGraphSalaryName
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Repository
public interface EmployeeGraphSalaryNameRepository extends PagingAndSortingRepository<EmployeeGraphSalaryName, Long> {
  
    @Query(value = "SELECT EMPLOYEE_ID, salary FROM employees ", nativeQuery = true)
    List<EmployeeGraphSalaryName> findIdAndSalary();
    
    @Query(value = "SELECT EMPLOYEE_ID, salary FROM employees ORDER BY salary ASC", nativeQuery = true)
    List<EmployeeGraphSalaryName> findIdAndSalaryAsc();

}