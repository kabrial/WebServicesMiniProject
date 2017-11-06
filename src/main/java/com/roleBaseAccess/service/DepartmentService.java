package com.roleBaseAccess.service;

import java.util.List;

import com.roleBaseAccess.model.Department;
/**
 * Interface Service Country
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface DepartmentService {
    List<Department> findDepartmentId(long DepartmentId);
    
    Iterable<Department> findAllDepartments();
    
    Department findDepartment(long departmentId);
    
    void saveDepartment(Department department);
}
