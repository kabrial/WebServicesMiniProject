package com.roleBaseAccess.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.roleBaseAccess.model.EmployeeGraphSalaryName;
import com.roleBaseAccess.service.EmployeeService;

/**
 * Rest Controller EmployeeIdSalary
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */

@RestController
public class EmployeeIdSalaryRestController {
    
    // Services
    @Autowired
    EmployeeService employeeService;

    /**
     * Methode to return information employee (Id and the salary)
     * @return JSON
     */
    @RequestMapping(value = "/api/dataEmployee", method = RequestMethod.GET, produces = "application/json")
    public Map<String, Object> displayEmployeeJson() {

        HashMap<String, Object> map = new HashMap<String, Object>();
        
        List<EmployeeGraphSalaryName> listEmployee = employeeService.findIdAndSalary();

        map.put("employeeInformation", listEmployee);
        
        return map;
    }

}
