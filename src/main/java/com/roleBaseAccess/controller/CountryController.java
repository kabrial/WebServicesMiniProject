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

import com.roleBaseAccess.model.Country;
import com.roleBaseAccess.model.Region;
import com.roleBaseAccess.model.User;
import com.roleBaseAccess.service.CountryService;
import com.roleBaseAccess.service.RegionService;
import com.roleBaseAccess.service.UserService;


/**
 * Country Controller
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Controller
@RequestMapping(path="/country")
public class CountryController {
    // Services.
    @Autowired
    CountryService countryService;
    
    @Autowired
    RegionService regionService;
    
    @Autowired
    UserService userService;
    
    // Variables.
    final String SALES = "SALES";
    final String ACCOUNTING = "ACCOUNTING";
    
    /**
     * display findALL
     * @param model
     * @return String
     */
    @GetMapping
    public String listAllCountries(Model model){
        
        Iterable<Country> listCountry = countryService.findAllCountries();

        model.addAttribute("listCountry",listCountry);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        
        return "country";
                
    }
    /**
     * update Country
     * @param model
     * @param countryId
     * @return String
     */
    @RequestMapping(value="/{countryId}",  method={RequestMethod.GET})
    public String findCountryId(Model model, @PathVariable String countryId){
        
        Country country = countryService.findCountry(countryId);        
        model.addAttribute("theCountry", country);
        
        Iterable<Region> listRegion = regionService.findAllRegion();

        model.addAttribute("listRegion",listRegion);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES) || user.getUserrole().equals(ACCOUNTING)) {
            return "redirect:/country";
        }
        return "updateCountry";
        
    }
    /**
     * update Country
     * @param model
     * @param countryId
     * @param country
     * @return String
     */
    @RequestMapping(value="/{countryId}",  method={RequestMethod.POST})
    public String updCountry(Model model,@PathVariable String countryId,@ModelAttribute Country country){

        model.addAttribute("theCountry", country);      
        countryService.saveCountry(country);
        
        return "redirect:/country";
    }
}

