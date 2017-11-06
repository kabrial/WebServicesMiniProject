package com.roleBaseAccess.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.roleBaseAccess.model.Department;
/**
 * Repository Department
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

    List<Department> findByDepartmentId(long departmentId);

}