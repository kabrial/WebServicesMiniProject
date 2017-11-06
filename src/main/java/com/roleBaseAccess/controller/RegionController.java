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

import com.roleBaseAccess.model.Region;
import com.roleBaseAccess.model.User;
import com.roleBaseAccess.service.RegionService;
import com.roleBaseAccess.service.UserService;

/**
 * Region Controller
 * @author kevin
 *
 */
@Controller
@RequestMapping(path="/region")
public class RegionController {
    // Services.
    @Autowired
    RegionService regionService;
    
    @Autowired
    UserService userService;
    // Variables
    final String SALES = "SALES";
    final String ACCOUNTING = "ACCOUNTING";
    /**
     * display all region
     * @param model
     * @return String
     */
    @GetMapping
    public String listAllRegions(Model model){
        
        Iterable<Region> listRegion = regionService.findAllRegion();

        model.addAttribute("listRegion",listRegion);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());

        
        return "region";
                
    }
    /**
     * regionId
     * @param model
     * @param regionId
     * @return String
     */
    @RequestMapping(value="/{regionId}",  method={RequestMethod.GET})
    public String findregionId(Model model, @PathVariable long regionId){
        
        Region region = regionService.findRegion(regionId);        
        model.addAttribute("theRegion", region);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES) || user.getUserrole().equals(ACCOUNTING)) {
            return "redirect:/region";
        }
        return "updateRegion";
        
    }
    /**
     * regionId
     * @param model
     * @param regionId
     * @param region
     * @return String
     */
    @RequestMapping(value="/{regionId}",  method={RequestMethod.POST})
    public String updregion(Model model,@PathVariable String regionId,@ModelAttribute Region region){

        model.addAttribute("theRegion", region);      
        regionService.saveRegion(region);
        
        return "redirect:/region";
    }
}

