package com.home.E_login.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
	
	
	
	
	@GetMapping("/login")
	public String login() {
        return "/login";
    }
	
	@GetMapping("/allUser")
	public String allUser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();
		if(auth.isAuthenticated()) {
			if(role.equals("[ROLE_ADMIN]")) {
				return "admin";
			}
			else {
				return "user";
			}
		}
        return "/login";
    }
	
	
	   @GetMapping("/403")
	    public String error403() {
	        return "/error/403";
	    }

}
