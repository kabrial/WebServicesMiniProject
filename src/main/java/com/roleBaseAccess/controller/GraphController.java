package com.roleBaseAccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roleBaseAccess.model.EmployeeGraphSalaryName;
import com.roleBaseAccess.model.User;
import com.roleBaseAccess.service.EmployeeService;
import com.roleBaseAccess.service.UserService;

/**
 * Graph controller
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Controller
@RequestMapping(path="/graph")
public class GraphController {
    
    // Services
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    UserService userService;
    
    // Variables.
    final String SALES = "SALES";
    final String ACCOUNTING = "ACCOUNTING";
    
    /**
     * display salary to plot
     * @param model
     * @return String
     */
    @GetMapping
    public String listAllSalaryGraph(Model model){
        
        List<EmployeeGraphSalaryName> listEmployee = employeeService.findIdAndSalary();

        model.addAttribute("listEmployee",listEmployee);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES) || user.getUserrole().equals(ACCOUNTING)) {
            return "redirect:/";
        }
        return "graph";
                
    }
    
    /**
     * /decile per decile plot
     * @param model
     * @return String
     */
    @RequestMapping(value="/decile",  method={RequestMethod.GET})
    public String listAllSalaryPerDecile(Model model){
        
        List<EmployeeGraphSalaryName> listEmployee = employeeService.findIdAndSalary();

        model.addAttribute("listEmployee",listEmployee);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES) || user.getUserrole().equals(ACCOUNTING)) {
            return "redirect:/";
        }
        return "graphPerDecile";
                
    }
    
}
