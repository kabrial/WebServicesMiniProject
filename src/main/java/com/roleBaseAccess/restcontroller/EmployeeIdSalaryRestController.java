package com.roleBaseAccess.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.roleBaseAccess.model.EmployeeGraphSalaryName;
import com.roleBaseAccess.model.User;
import com.roleBaseAccess.service.EmployeeService;
import com.roleBaseAccess.service.UserService;

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
    
    @Autowired
    UserService userService;
    
    // Variables.
    final String SALES = "SALES";
    final String ACCOUNTING = "ACCOUNTING";

    /**
     * Methode to return information employee (Id and the salary)
     * @return JSON
     */
    @RequestMapping(value = "/api/dataEmployee", method = RequestMethod.GET, produces = "application/json")
    public Map<String, Object> displayEmployeeJson() {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);

        if ( user.getUserrole().equals(SALES) || user.getUserrole().equals(ACCOUNTING)) {
            HashMap<String, Object> mapError = new HashMap<String, Object>();
            mapError.put("AccessDenied", "AccessDenied");
            return mapError;
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        
        List<EmployeeGraphSalaryName> listEmployee = employeeService.findIdAndSalary();

        map.put("employeeInformation", listEmployee);
        
        return map;
    }

    
    /**
     * Methode to return information employee (Id and the salary)
     * @return JSON
     */
    @RequestMapping(value = "/api/dataEmployeeAsc", method = RequestMethod.GET, produces = "application/json")
    public Map<String, Object> displayEmployeeJsonAsc() {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);

        if ( user.getUserrole().equals(SALES) || user.getUserrole().equals(ACCOUNTING)) {
            HashMap<String, Object> mapError = new HashMap<String, Object>();
            mapError.put("AccessDenied", "AccessDenied");
            return mapError;
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        
        List<EmployeeGraphSalaryName> listEmployee = employeeService.findIdAndSalaryAsc();

        map.put("employeeInformation", listEmployee);
        
        return map;
    }
}
