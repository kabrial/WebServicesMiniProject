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
import com.roleBaseAccess.model.Location;
import com.roleBaseAccess.model.User;
import com.roleBaseAccess.service.CountryService;
import com.roleBaseAccess.service.LocationService;
import com.roleBaseAccess.service.UserService;

/**
 * Location Controller
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Controller
@RequestMapping(path="/location")
public class LocationController {
    // Services.
    @Autowired
    LocationService locationService;
    
    @Autowired
    CountryService countryService;
    
    @Autowired
    UserService userService;
    // Variable
    final String SALES = "SALES";
    final String ACCOUNTING = "ACCOUNTING";
    /**
     * display All locations
     * @param model
     * @return String
     */
    @GetMapping
    public String listAllLocations(Model model){
        
        Iterable<Location> listLocation = locationService.findAllLocation();
        model.addAttribute("listLocation",listLocation);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userService.findByUsername(username);
        model.addAttribute("userRole",user.getUserrole());
        model.addAttribute("userName",username);

        return "location";
                
    }
    /**
     * locationId
     * @param model
     * @param locationId
     * @return String
     */
    @RequestMapping(value="/{locationId}",  method={RequestMethod.GET})
    public String findLocationId(Model model, @PathVariable long locationId){
        
        Location Location = locationService.findLocation(locationId);        
        model.addAttribute("theLocation", Location);
        
        
        Iterable<Country> listCountry = countryService.findAllCountries();

        model.addAttribute("listCountry",listCountry);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES) || user.getUserrole().equals(ACCOUNTING)) {
            return "redirect:/location";
        }
        return "updateLocation";
        
    }
    
    /**
     * locationId
     * @param model
     * @param locationId
     * @param location
     * @return String
     */
    @RequestMapping(value="/{locationId}",  method={RequestMethod.POST})
    public String updLocation(Model model,@PathVariable String locationId,@ModelAttribute Location location){

        model.addAttribute("theLocation", location);      
        locationService.saveLocation(location);
        
        return "redirect:/location";
    }
}

