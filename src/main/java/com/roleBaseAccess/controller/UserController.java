package com.roleBaseAccess.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.roleBaseAccess.model.User;
import com.roleBaseAccess.service.SecurityService;
import com.roleBaseAccess.service.UserService;
import com.roleBaseAccess.validator.UserModifyPasswordValidator;
import com.roleBaseAccess.validator.UserValidator;

/**
 * @author Kevin ABRIAL & Alexis Barthelemy
 *
 */
@Controller
public class UserController {
    // Service
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private UserModifyPasswordValidator userModifyPasswordValidator;
    
    // Variables.
    final String SALES = "SALES";
    final String ACCOUNTING = "ACCOUNTING";
    
    /**
     * display findAll User
     * @return ModelAndView
     */
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    
    /**
     * registration
     * @return ModelAndView
     */
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /**
     * registration
     * @param userForm
     * @param bindingResult
     * @param model
     * @return String
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        
        return "redirect:/userAdmin";
    }

    /**
     * login
     * @param model
     * @param error
     * @param logout
     * @return String
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    /**
     * / 
     * @param model
     * @return String
     */
    @RequestMapping(value = {"/", "/userAdmin"}, method = RequestMethod.GET)
    public String userAdmin(Model model) {
       
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        if ( user.getUserrole().equals(SALES)) {
            return "userSalesAndFinance";
        } else {
            if ( user.getUserrole().equals(ACCOUNTING)) {
                return "userAccounting";
            }
        }
        return "userAdmin";
    }
    
    /**
     * your profil
     * @param model
     * @return String
     */
    @RequestMapping(value = "/yourProfil", method = RequestMethod.GET)
    public String login(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());
        User userCurrent = userService.displayAUser(user);
        model.addAttribute("userCurrent",userCurrent);
        return "yourProfil";
    }
    
    /**
     * profil Modify
     * @param model
     * @return String
     */
    @RequestMapping(value = "/profilModify", method = RequestMethod.GET)
    public String displayProfilModify(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User user = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",user.getUserrole());       
        model.addAttribute("theUser", user);
        return "profilModify";
    }
    
    /**
     * profil Modify 
     * @param user
     * @param bindingResult
     * @param model
     * @return String
     */
    @RequestMapping(value = "/profilModify", method = RequestMethod.POST)
    public String profilModify(@ModelAttribute("theUser") User user, BindingResult bindingResult, Model model) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        
        User userCurrent = userService.findByUsername(username);
        model.addAttribute("userName",username);
        model.addAttribute("userRole",userCurrent.getUserrole()); 
 
        userModifyPasswordValidator.validate(user, bindingResult);
 
        if (bindingResult.hasErrors()) {
            return "profilModify";
        }
        
        userService.saveModifyPassword(user, userCurrent.getId());
        
        return "redirect:/logout";
    }

}
