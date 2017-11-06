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
import com.roleBaseAccess.model.Location;
import com.roleBaseAccess.model.User;
import com.roleBaseAccess.service.DepartmentService;
import com.roleBaseAccess.service.LocationService;
import com.roleBaseAccess.service.UserService;



/**
 * Department Controller
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Controller
@RequestMapping(path="/department")
public class DepartmentController {
    // Services.
    @Autowired
    DepartmentService departmentService;
    
    @Autowired
    LocationService locationService;
    
    @Autowired
    UserService userService;
    
    // Variables.
    final String SALES = "SALES";
    final String ACCOUNTING = "ACCOUNTING";
    
    /**
     * display find all
     * @param model
     * @return String
     */
    @GetMapping
    public String listAllDepartments(Model model){
        
        Iterable<Department> listDepartment = departmentService.findAllDepartments();

        model.addAttribute("listDepartment",listDepartment);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES) ){
            return "redirect:/";
        } 
        return "department";
                
    }
    
    /**
     * display update Department
     * @param model
     * @param departmentId
     * @return String
     */
    @RequestMapping(value="/{departmentId}",  method={RequestMethod.GET})
    public String finddepartmentId(Model model, @PathVariable long departmentId){
        
        Department department = departmentService.findDepartment(departmentId);        
        model.addAttribute("theDepartment", department);
        
        Iterable<Location> listLocation = locationService.findAllLocation();

        model.addAttribute("listLocation",listLocation);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(ACCOUNTING) ){
            return "redirect:/department";
        } 
        return "updateDepartment";
        
    }
    
    /**
     * post update Department
     * @param model
     * @param departmentId
     * @param department
     * @return
     */
    @RequestMapping(value="/{departmentId}",  method={RequestMethod.POST})
    public String upddepartment(Model model,@PathVariable long departmentId,@ModelAttribute Department department){

        model.addAttribute("theDepartment", department);      
        departmentService.saveDepartment(department);
        
        return "redirect:/department";
    }
}

