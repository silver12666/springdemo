package com.akhambir.controllers;

import com.akhambir.model.User;
import com.akhambir.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.Logger;
import javax.validation.Valid;

@Controller
public class UserController {

    Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private Facebook facebook;


    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error",required = false) String error,
                                 @RequestParam(value = "logout",	required = false) String logout,
                                 ModelAndView vm) {
        if (error != null) {
            vm.addObject("error", "Invalid Credentials provided.");
        }

        if (logout != null) {
            vm.addObject("message", "Logged out from JournalDEV successfully.");
        }

        vm.setViewName("login");
        vm.addObject("user", new User());
        return vm;
    }

    /*@RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, ModelAndView vm) {
        return vm;
    }*/

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    public ModelAndView signup(ModelAndView vm) {
        vm.setViewName("signup");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult result, ModelAndView vm) {
        if (result.hasErrors()) {
            vm.setViewName("signup");
            vm.addObject("user", new User());
            return "signup";
        }
        vm.setViewName("welcome");
        vm.addObject("user", userService.addUser(user));
        return "welcome";
    }

    @RequestMapping(path = "/activate-user/{token}", method = RequestMethod.GET)
    public ModelAndView activate(@PathVariable String token, ModelAndView vm) {
        User user = userService.findByToken(token);
        userService.activate(user);
        vm.setViewName("activation");
        return vm;
    }

    @RequestMapping("/social")
    public String helloFacebook(Model vm) {
        /*if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }*/

        //vm.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        return "social";
    }

}
