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

import com.roleBaseAccess.model.Job;
import com.roleBaseAccess.model.User;
import com.roleBaseAccess.service.JobService;
import com.roleBaseAccess.service.UserService;

/**
 * Job Controller 
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Controller
@RequestMapping(path="/job")
public class JobController {
    // Services
    @Autowired
    JobService JobService;
    
    @Autowired
    UserService userService;
    
    // Variables
    final String SALES = "SALES";
    
    /**
     * display all countries
     * @param model
     * @return String
     */
    @GetMapping
    public String listAllCountries(Model model){
        
        Iterable<Job> listJob = JobService.findAllJobs();

        model.addAttribute("listJob",listJob);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES) ){
            return "redirect:/";
        } 
        return "job";
                
    }
    
    /**
     * jobId
     * @param model
     * @param jobId
     * @return String
     */
    @RequestMapping(value="/{jobId}",  method={RequestMethod.GET})
    public String findJobId(Model model, @PathVariable String jobId){
        
        Job job = JobService.findJob(jobId);        
        model.addAttribute("theJob", job);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
       
        
        return "updateJob";
        
    }
    
    /**
     * jobId Post
     * @param model
     * @param jobId
     * @param job
     * @return String
     */
    @RequestMapping(value="/{jobId}",  method={RequestMethod.POST})
    public String updJob(Model model,@PathVariable String jobId,@ModelAttribute Job job){

        model.addAttribute("theJob", job);      
        JobService.saveJob(job);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES) ){
            return "redirect:/";
        } 
        return "redirect:/job";
    }
}

