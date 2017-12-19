package com.colo.controller;

import com.colo.data.users.Role;
import com.colo.data.users.User;
import com.colo.data.users.UserValidator;
import com.colo.forms.LoginForm;
import com.colo.mail.MailSender;
import com.colo.service.SecurityService;
import com.colo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Controller
public class LoginController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired private UserService userService;
    @Autowired private SecurityService securityService;
    @Autowired private UserValidator userValidator;
    @Autowired private MailSender mailSender;

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, Model model) {
//        if (securityService.autologin(loginForm.getUsername(), loginForm.getPassword())) {
////            model.add
////            result.reject("authentication.failed");
//            return "login";
//        }
//        return "result";
//    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getAllErrors());
            return "registration";
        }
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("user"));
        userForm.setRoles(roles);
        userService.save(userForm);
        securityService.autologin(userForm.getUsername(), userForm.getPassword());
        mailSender.sendNewUserMail(userForm.getEmailAddress());
        return "redirect:/user";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "homepage";
    }

    @RequestMapping("/authenticate")
    public String authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean authenticate = request.authenticate(response);
        return authenticate ? "index" : null;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm) {
        return "login";
    }

}
