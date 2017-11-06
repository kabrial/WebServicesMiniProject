package com.roleBaseAccess.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roleBaseAccess.model.Department;
import com.roleBaseAccess.repository.DepartmentRepository;
import com.roleBaseAccess.service.DepartmentService;

/**
 * Class ServiceImpl Department
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    // Repository  
    @Autowired
    final DepartmentRepository departmentRepository;
    // Constructor
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * find Department Id
     */
    @Override
    public List<Department> findDepartmentId(long DepartmentId) {
        return departmentRepository.findByDepartmentId(DepartmentId);
    }

    /**
     * find All Departments
     */
    @Override
    public Iterable<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    /**
     * find One departmentId
     */
    @Override
    public Department findDepartment(long departmentId) {
        return departmentRepository.findOne(departmentId);
    }

    /**
     * Save Department
     */
    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

}