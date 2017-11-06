package com.roleBaseAccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roleBaseAccess.model.Department;
import com.roleBaseAccess.model.Employee;
import com.roleBaseAccess.model.Job;
import com.roleBaseAccess.model.User;
import com.roleBaseAccess.service.DepartmentService;
import com.roleBaseAccess.service.EmployeeService;
import com.roleBaseAccess.service.JobService;
import com.roleBaseAccess.service.UserService;

/**
 * Employee Controller
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Controller
@RequestMapping(path="/employee")
public class EmployeeController {
    //Services.
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    DepartmentService departmentService;
    
    @Autowired
    JobService jobService;
    
    @Autowired
    UserService userService;
    
    // Variables.
    final String SALES = "SALES";
    
    /**
     * display find all country
     * @param model
     * @return String
     */
    @GetMapping
    public String listAllCountries(Model model){
        
        Iterable<Employee> listEmployee = employeeService.findAllEmployee();

        model.addAttribute("listEmployee",listEmployee);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES) ){
            return "redirect:/";
        } 
        return "employee";

                
    }
    
    @RequestMapping(value="/{EmployeeId}",  method={RequestMethod.GET})
    public String findEmployeeId(Model model, @PathVariable long EmployeeId){
        
        Employee Employee = employeeService.findEmployee(EmployeeId);        
        model.addAttribute("theEmployee", Employee);
        
        Iterable<Department> listDepartment = departmentService.findAllDepartments();

        model.addAttribute("listDepartment",listDepartment);
        
        Iterable<Job> listJob = jobService.findAllJobs();

        model.addAttribute("listJob",listJob);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES) ){
            return "redirect:/";
        } 
        return "updateEmployee";
        
    }
    
    @RequestMapping(value="/{EmployeeId}",  method={RequestMethod.POST})
    public String updEmployee(Model model,@PathVariable String EmployeeId,@ModelAttribute Employee Employee){

        model.addAttribute("theEmployee", Employee);      
        employeeService.saveEmployee(Employee);
        
        return "redirect:/employee";
    }
}

